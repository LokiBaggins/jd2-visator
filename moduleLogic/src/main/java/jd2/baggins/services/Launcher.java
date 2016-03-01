package jd2.baggins.services;

import jd2.baggins.TestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-front-config.xml");

        TestBean tb = (TestBean) appContext.getBean("tester");

        System.out.println("tester = " + tb);
    }
}
