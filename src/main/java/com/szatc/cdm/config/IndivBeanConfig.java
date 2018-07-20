package com.szatc.cdm.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.szatc.cdm.common.adapter.CalendarAdapter;
import com.szatc.cdm.resolver.DepOrderResolver;
import com.szatc.cdm.resolver.DlMsgResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.lang.reflect.Modifier;
import java.util.Calendar;

/**
 * 普通Bean配置
 *
 * @author liuweijian
 * @date 2018/1/10
 */
@Configuration
public class IndivBeanConfig {


    @Bean(name = "gson")
    public Gson gson() {
        return new GsonBuilder()
                .registerTypeHierarchyAdapter(Calendar.class, new CalendarAdapter())
                .create();
    }


    /**
     * 排除修饰符为PROTECTED类型的
     * @return
     */
    @Bean(name = "gson2")
    public Gson gson2() {
        return new GsonBuilder()
                .registerTypeHierarchyAdapter(Calendar.class, new CalendarAdapter()).excludeFieldsWithModifiers(Modifier.PROTECTED)
                .create();
    }



    @Bean
    public DlMsgResolver dlMsgResolver(){

        return new DlMsgResolver();
    }



    @Bean
    public  DepOrderResolver depOrderResolver(){
        return  new DepOrderResolver();
    }

    /**定时任务线程池
     * @return
     */
    @Bean(name = "CDMTask")
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        return taskScheduler;
    }

}
