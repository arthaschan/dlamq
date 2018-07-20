package com.szatc.cdm.common.adapter;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.szatc.cdm.common.util.DateUtil;

import java.lang.reflect.Type;
import java.util.Calendar;

/**
 * Gson使用的Calendar适配器
 *
 * @author liuweijian
 * @date 2018/1/7
 */
public class CalendarAdapter implements JsonSerializer<Calendar> {
    @Override
    public JsonElement serialize(Calendar calendar, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(DateUtil.format(calendar));
    }
}
