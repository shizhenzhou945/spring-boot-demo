package com.github.wenslo.springbootdemo.util;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Map;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-02-23 19:42
 * @description excel 工具类
 */
@Component
public class ExcelUtil {
    private static final Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    public void export(String templatePath, Map<String, Object> variable, OutputStream outputStream) throws FileNotFoundException {

        try (InputStream inputStream = new FileInputStream(templatePath)) {
            Context context = map2Context(variable);
            JxlsHelper.getInstance().processTemplate(inputStream, outputStream, context);
        } catch (FileNotFoundException e) {
            logger.error("template file not found , file path is {}", templatePath);
            throw e;
        } catch (IOException e) {
            logger.error("excel export has a error ", e);
        }
    }

    private Context map2Context(Map<String, Object> variable) {
        Context context = new Context();
        variable.forEach((k, v) -> {
            context.putVar(k, v);
        });
        return context;
    }
}
