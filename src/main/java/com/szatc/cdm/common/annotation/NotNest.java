package com.szatc.cdm.common.annotation;

import java.lang.annotation.*;

/**
 * 标志性注解：标识字段不应被解析成为嵌套的Json
 *
 * @author liuweijian
 * @date 2017/12/30
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNest {
}
