package com.szatc.cdm.amq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 普通方法的测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Test
    public void hello() {
        System.out.println("hello world");
    }


    //userMapper  的测试

    //简单验证结果集是否正确
//Assert.assertEquals(3, userMapper.getAll().size());
//
////验证结果集，提示
//Assert.assertTrue("错误，正确的返回值为200", status == 200);
//Assert.assertFalse("错误，正确的返回值为200", status != 200);


}