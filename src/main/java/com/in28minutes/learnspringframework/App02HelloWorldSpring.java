package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        // Launch a Spring Context
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        // Configure the things that we want Spring to manage
        // HelloWorldConfiguration - @Configuration
        // name - @Bean

        // Retrieving Beans Managed by Spring
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("person2MethodCall"));
        System.out.println(context.getBean("person3Parameters"));
        System.out.println(context.getBean("address2"));
        System.out.println(context.getBean(Address.class));

    }
}
