package com.github.wenslo.springbootdemo.security.provider;

import com.github.wenslo.springbootdemo.domain.Response;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月08日 下午12:48
 * @description
 */
@Component
public class MainAccessDeniedHandler implements AccessDeniedHandler {
    @Autowired
    private Gson gson;
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.append(gson.toJson(Response.FORBIDDEN));
        writer.flush();
    }
}
