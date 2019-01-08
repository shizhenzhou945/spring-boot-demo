package com.github.wenslo.springbootdemo.observer;

import com.github.wenslo.springbootdemo.annotation.eventbus.Observer;
import com.github.wenslo.springbootdemo.model.system.OperateRecord;
import com.github.wenslo.springbootdemo.observer.event.Event;
import com.github.wenslo.springbootdemo.reposiroty.system.OperateRecordRepository;
import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-06 16:22
 * @description
 */
@Observer
public class EventObserver {

    private static final Logger logger = LoggerFactory.getLogger(EventObserver.class);
    @Autowired
    private OperateRecordRepository operateRecordRepository;

    @Subscribe
    public void call(Event event) {
        if (event instanceof OperateRecord) {
            operateRecordRepository.save((OperateRecord) event);
        }
    }
}
