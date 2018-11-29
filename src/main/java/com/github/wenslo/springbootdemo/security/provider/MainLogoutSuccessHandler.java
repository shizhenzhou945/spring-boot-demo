package com.github.wenslo.springbootdemo.security.provider;

import org.springframework.http.HttpStatus;
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
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.append("{\"code\":").append(String.valueOf(HttpStatus.OK.value())).append(",\"msg\":\"登出成功\"}");
        writer.flush();
        writer.close();
    }
}
