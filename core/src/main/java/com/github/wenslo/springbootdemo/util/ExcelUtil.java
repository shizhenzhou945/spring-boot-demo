package com.github.wenslo.springbootdemo.util;

import com.github.wenslo.springbootdemo.enums.ExcelPattern;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Map;
import java.util.UUID;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-02-23 19:42
 * @description excel 工具类
 */
@Component
public class ExcelUtil {
    private static final Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    public String export(String templatePath, Map<String, Object> variable, ExcelPattern excelPattern) throws IOException {
        try (InputStream inputStream =  this.getClass().getResourceAsStream(templatePath)) {
            Context context = map2Context(variable);
            String filePath = generateFilePath(excelPattern);
            try (OutputStream outputStream = new FileOutputStream(filePath)) {
                JxlsHelper.getInstance().processTemplate(inputStream, outputStream, context);
            }
            return filePath;
        } catch (FileNotFoundException e) {
            logger.error("template file not found , file path is {}", templatePath);
            throw e;
        } catch (IOException e) {
            logger.error("excel export has a error ", e);
            throw e;
        }
    }

    public String export(String templatePath, Map<String, Object> variable) throws IOException {
        return export(templatePath, variable, ExcelPattern.xls);
    }

    private Context map2Context(Map<String, Object> variable) {
        Context context = new Context();
        variable.forEach(context::putVar);
        return context;
    }

    public String generateFilePath(ExcelPattern excelPattern) {
        String tmpDir = "/tmp/generatedExcel";
        File file = new File(tmpDir);
        if (!file.exists()) {
            file.mkdir();
        }
        String fileName = UUID.randomUUID().toString() + "." + excelPattern;
        return tmpDir + File.pathSeparator + fileName;
    }
}
