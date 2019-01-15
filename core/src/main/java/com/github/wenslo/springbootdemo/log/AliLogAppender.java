package com.github.wenslo.springbootdemo.log;

import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.classic.spi.ThrowableProxyUtil;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import ch.qos.logback.core.encoder.Encoder;
import com.aliyun.openservices.aliyun.log.producer.LogProducer;
import com.aliyun.openservices.aliyun.log.producer.ProducerConfig;
import com.aliyun.openservices.aliyun.log.producer.ProjectConfig;
import com.aliyun.openservices.aliyun.log.producer.ProjectConfigs;
import com.aliyun.openservices.aliyun.log.producer.errors.ProducerException;
import com.aliyun.openservices.log.common.LogItem;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-14 22:36
 * @description
 */
@Getter
@Setter
public class AliLogAppender<E> extends UnsynchronizedAppenderBase<E> {
    protected Encoder<E> encoder;
    private String project;
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String topic;
    private String logstore;
    private String source = "";
    private String aliLogScan;
    LogProducer producer;
    ProjectConfigs projectConfigs;
    ProjectConfig projectConfig;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void start() {
        try {
            projectConfigs = new ProjectConfigs();
            projectConfig = new ProjectConfig(project, endpoint, accessKeyId, accessKeySecret);
            projectConfigs.put(projectConfig);
            doStart();
        } catch (Exception e) {
            addError("Failed to start AliLogAppender.", e);
        }
    }

    private void doStart() {
        projectConfigs.put(projectConfig);
        ProducerConfig producerConfig = new ProducerConfig(projectConfigs);
        producer = new LogProducer(producerConfig);
        super.start();
    }

    @Override
    public void stop() {
        try {
            doStop();
        } catch (Exception e) {
            addError("Failed to stop AliLogAppender.", e);
        }
    }

    private void doStop() throws ProducerException, InterruptedException {
        super.stop();
        producer.close();
    }

    @Override
    protected void append(E eventObject) {
        if (!(eventObject instanceof LoggingEvent)) {
            return;
        }
        LoggingEvent event = (LoggingEvent) eventObject;
        if (StringUtils.isBlank(aliLogScan)) {
            send(event);
        } else {
            String loggerName = event.getLoggerName();
            Arrays.stream(aliLogScan.split(",")).forEach(it -> {
                if (loggerName.contains(it)) {
                    send(event);
                }
            });
        }
    }

    private void send(LoggingEvent event) {
        List<LogItem> logItems = new ArrayList<>();
        LogItem item = new LogItem();
        logItems.add(item);
        item.SetTime((int) (event.getTimeStamp() / 1000));

        Date dateTime = new Date(event.getTimeStamp());
        item.PushBack("time", sdf.format(dateTime));
        item.PushBack("level", event.getLevel().toString());
        item.PushBack("thread", event.getThreadName());

        StackTraceElement[] caller = event.getCallerData();
        if (caller != null && caller.length > 0) {
            item.PushBack("location", caller[0].toString());
        }

        String message = event.getFormattedMessage();
        item.PushBack("message", message);

        IThrowableProxy iThrowableProxy = event.getThrowableProxy();
        if (iThrowableProxy != null) {
            String throwable = iThrowableProxy.getMessage();
            throwable += fullDump(event.getThrowableProxy().getStackTraceElementProxyArray());
            item.PushBack("throwable", throwable);
        }

        try {
            producer.send(projectConfig.getProject(), logstore, topic, source, logItems);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ProducerException e) {
            e.printStackTrace();
        }
    }

    private String fullDump(StackTraceElementProxy[] stackTraceElementProxyArray) {
        StringBuilder builder = new StringBuilder();
        for (StackTraceElementProxy step : stackTraceElementProxyArray) {
            builder.append(CoreConstants.LINE_SEPARATOR);
            String string = step.toString();
            builder.append(CoreConstants.TAB).append(string);
            ThrowableProxyUtil.subjoinPackagingData(builder, step);
        }
        return builder.toString();
    }
}
