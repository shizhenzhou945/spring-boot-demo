package com.github.wenslo.springbootdemo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-15 22:34
 * @description 腾讯COS util
 */
@Component
public class COSUtil {
    private static final String BUCKET_NAME_KEY = "BucketName";
    private static final String APP_ID_KEY = "APPID";
    private static final String REGION_KEY = "Region";
    @Autowired
    private Environment environment;
    @Autowired
    private WebClient webClient;

    public void populateHeader() {
//        webClient.
    }

    public String getCOSHost() {
        StringBuffer buffer = new StringBuffer();
        String bucketName = environment.getProperty(BUCKET_NAME_KEY);
        String appId = environment.getProperty(APP_ID_KEY);
        String region = environment.getProperty(REGION_KEY);
        buffer.append(bucketName).append("-").append(appId).append(".cos.").append(region).append(".myqcloud.com");
        return buffer.toString();
    }
}
