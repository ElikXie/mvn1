package com.xp.test;

import com.xp.hema.dao.UserDao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo01 {
    @Test
    public void test01(){
        ApplicationContext app = new ClassPathXmlApplicationContext("acontext.xml");
        UserDao u1 =(UserDao) app.getBean("userDao");
        UserDao u2 = (UserDao) app.getBean("userDao");
        System.out.println(u1);
        System.out.println(u2);
        u1.save();

    }
}
