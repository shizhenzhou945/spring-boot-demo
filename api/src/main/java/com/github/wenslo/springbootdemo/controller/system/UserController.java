package com.github.wenslo.springbootdemo.controller.system;

import com.github.wenslo.springbootdemo.condition.system.UserCondition;
import com.github.wenslo.springbootdemo.controller.BaseController;
import com.github.wenslo.springbootdemo.domain.Response;
import com.github.wenslo.springbootdemo.model.system.User;
import com.github.wenslo.springbootdemo.service.system.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月02日 下午1:47
 * @description
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    public Response save(@RequestBody User user) {
        userService.save(user);
        logger.debug("That be saved user is {}", gson.toJson(user));
        return Response.SUCCESS;
    }

    @RequestMapping("/queryAll")
    public Response getAll() {
        logger.debug("The current thread id is {} ", Thread.currentThread().getId());
        return Response.success(userService.getAll());
    }

    @RequestMapping("/queryByPage")
    public Page<User> queryByPage(@RequestBody UserCondition condition) {
        logger.debug("The currently operator is {}, condition is {}", getLoginUsername(), gson.toJson(condition));
        return userService.getByCondition(condition, condition.getPageable());
    }
}
