package com.github.wenslo.springbootdemo.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.wenslo.springbootdemo.security.model.AuthenticationBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import static org.springframework.http.HttpStatus.UNSUPPORTED_MEDIA_TYPE;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月29日 下午6:19
 * @description
 */
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Unsupported request method");
        }
        if (Objects.equals(MediaType.APPLICATION_JSON_VALUE, request.getContentType())
                || Objects.equals(MediaType.APPLICATION_JSON_UTF8_VALUE, request.getContentType())) {
            ObjectMapper mapper = new ObjectMapper();
            UsernamePasswordAuthenticationToken authRequest = null;
            try (InputStream is = request.getInputStream()) {
                AuthenticationBean authenticationBean = mapper.readValue(is, AuthenticationBean.class);
                authRequest = new UsernamePasswordAuthenticationToken(
                        authenticationBean.getUsername(), authenticationBean.getPassword());
            } catch (IOException e) {
                logger.error("obtainUsername is error", e);
                authRequest = new UsernamePasswordAuthenticationToken(
                        "", "");
            }
            setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
        } else {
            throw new AuthenticationServiceException(UNSUPPORTED_MEDIA_TYPE.getReasonPhrase());
        }

    }
}
