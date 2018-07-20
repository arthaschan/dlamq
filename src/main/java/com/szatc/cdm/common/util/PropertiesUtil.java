package com.szatc.cdm.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author liuweijian
 * 属性文件工具类
 */
public class PropertiesUtil {
    /**
     * 获取属性文件
     * @param propPath classpath路径下的子路经/文件名
     * @return 属性文件实例
     */
    public static Properties  getProperties(String propPath) {
        Properties properties = new Properties();
        try {
            InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(propPath);
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException(propPath + "文件加载失败");
        }
        return properties;
    }
}
