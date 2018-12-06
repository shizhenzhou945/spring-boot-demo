package com.github.wenslo.springbootdemo.security.provider;

import com.github.wenslo.springbootdemo.domain.Response;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月29日 下午6:08
 * @description
 */
@Component
public class MainLogoutSuccessHandler implements LogoutSuccessHandler {
    @Autowired
    private Gson gson;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.append(gson.toJson(Response.LOGOUT_SUCCESS));
        writer.flush();
        writer.close();
    }
}
