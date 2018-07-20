package com.szatc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.tempuri.IParkingBayService;
import org.tempuri.ParkingBayService;

/**
 * @author Kuhn Wei, email@kuhnwei.com
 * @version 2018/4/28 11:08
 **/
@SpringBootApplication
@EnableScheduling
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackages="com.szatc.*")
public class StartSpringBootMain {
    public static void main(String[] args) {

        SpringApplication.run(StartSpringBootMain.class, args);

    }
}
