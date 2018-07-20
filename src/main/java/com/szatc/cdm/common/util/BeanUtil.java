package com.szatc.cdm.common.util;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ken on 2017/8/30.
 * 将数据库查询结果通过反射自动填充模型
 */
public class BeanUtil {

    private static final Logger logger = Logger.getLogger(BeanUtil.class);

    /**
     * @param clazz 模型class对象
     * @param rs 数据库结果集
     * @param <T>
     * @return 填充模型
     */
    public static <T> T getBeanFromResultSet(Class<T> clazz, ResultSet rs) {
        // 获得所有域
        Field[] declaredFields = clazz.getDeclaredFields();

        T obj = null;
        String fieldName = null;
        try {
            obj = clazz.newInstance();

            // 调用setter方法设置域
            for (Field field : declaredFields) {
                fieldName = field.getName();
                Method method = null;
                Object value = null;
                try {
                    // 获得值
                    value = rs.getString(fieldName.toUpperCase());
                    // 设置值
                    method = clazz.getMethod("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), String.class);
                } catch (NoSuchMethodException e) {
                    logger.warn("没有" + "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1) + "这样的方法");
                    logger.warn("跳过执行此方法！");
                    continue;
                } catch (SQLException e) {
                    logger.warn("获取字段：" + fieldName.toUpperCase() + "时出现异常");
                    logger.warn("跳过此字段设置！");
                    continue;
                }
                method.invoke(obj, value);
            }
        } catch (InstantiationException e) {
            logger.error(clazz.getName() + "实例化失败");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            logger.error("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1) + "方法调用参数错误");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            logger.error("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1) + "方法调用出错");
            e.printStackTrace();
        }
        return obj;
    }
}
