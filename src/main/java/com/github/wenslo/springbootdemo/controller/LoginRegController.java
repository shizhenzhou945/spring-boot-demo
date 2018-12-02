package com.github.wenslo.springbootdemo.controller;

import com.github.wenslo.springbootdemo.domain.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月29日 下午5:52
 * @description
 */
@RestController
public class LoginRegController {
    @RequestMapping("/login_page")
    public Response loginPage() {
        return Response.UNAUTHORIZED;
    }


}
