package com.github.wenslo.springbootdemo.security.provider;

import com.github.wenslo.springbootdemo.domain.Response;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月29日 下午5:46
 * @description
 */
@Component
public class MainAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Gson gson;


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        if (!StringUtils.isEmpty(exception.getMessage())) {
            writer.append(gson.toJson(new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage())));
        } else {
            writer.append(gson.toJson(Response.LOGIN_FAIL));
        }
        writer.flush();
        writer.close();
    }
}
