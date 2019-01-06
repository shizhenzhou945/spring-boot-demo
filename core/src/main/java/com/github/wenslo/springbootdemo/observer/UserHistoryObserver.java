package com.github.wenslo.springbootdemo.observer;

import com.github.wenslo.springbootdemo.annotation.eventbus.Observer;
import com.github.wenslo.springbootdemo.model.system.User;
import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-06 16:22
 * @description
 */
@Observer
public class UserHistoryObserver {

    private static final Logger logger = LoggerFactory.getLogger(UserHistoryObserver.class);

    @Subscribe
    public void call(User user) {
        //TODO 补充用户操作记录
        logger.debug("UserHistoryObserver is called");
    }
}
