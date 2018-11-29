package com.github.wenslo.springbootdemo.security.provider;

import com.github.wenslo.springbootdemo.domain.Response;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月29日 下午3:24
 * @description
 */
@Component
public class MainAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Autowired
    private Gson gson;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.append(gson.toJson(Response.UNAUTHORIZED));
        writer.flush();
    }
}
