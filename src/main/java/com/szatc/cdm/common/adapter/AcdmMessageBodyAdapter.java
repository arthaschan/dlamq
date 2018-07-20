package com.szatc.cdm.common.adapter;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.szatc.cdm.common.annotation.NotNest;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * Gson解析ACDM消息体的适配器
 *
 * @author liuweijian
 * @date 2017/12/30
 */
public class AcdmMessageBodyAdapter implements JsonSerializer<Object>{
    @Override
    public JsonElement serialize(Object o, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();

        try {
            //处理消息体中的[AirportInfoType,DelayCodeType,FlightKeyType,ReasonType]字段
            Class<?> clazz = Class.forName(type.getTypeName());
            Field[] declaredFields = clazz.getDeclaredFields();
            //遍历成员
            for (Field field : declaredFields) {
                field.setAccessible(true);
                //遍历标注了NotNest的成员
                if (field.isAnnotationPresent(NotNest.class)) {
                    Class<?> c = Class.forName(field.getType().getName());
                    Field[] memberDeclaredFields = c.getDeclaredFields();
                    Object member = field.get(o);
                    for (Field memberField : memberDeclaredFields) {
                        String name = memberField.getName();
                        memberField.setAccessible(true);
                        Object value = memberField.get(member);
                        //为null值赋空字符串""
                        if (value == null) {
                            jsonObject.addProperty(name, "");
                            continue;
                        }
                        jsonObject.add(name, jsonSerializationContext.serialize(value));
                    }
                } else { //处理普通字段
                    String name = field.getName();
                    Object value = field.get(o);
                    //为null值赋空字符串""
                    if (value == null) {
                        jsonObject.addProperty(name, "");
                        continue;
                    }
                    jsonObject.add(name, jsonSerializationContext.serialize(value));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
