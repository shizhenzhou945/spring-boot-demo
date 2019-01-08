package com.github.wenslo.springbootdemo.observer;

import com.github.wenslo.springbootdemo.annotation.eventbus.Observer;
import com.github.wenslo.springbootdemo.model.system.OperateRecord;
import com.github.wenslo.springbootdemo.observer.event.Event;
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
public class EventObserver {

    private static final Logger logger = LoggerFactory.getLogger(EventObserver.class);

    @Subscribe
    public void call(Event event) {
        if (event instanceof OperateRecord) {
            //TODO 补充操作记录
            logger.debug("OperateRecordObserver is called");

        }
    }
}
