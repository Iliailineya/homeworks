package org.example;

import org.example.bean.TestBean;
import org.example.configuration.TestBeanConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestBeanConfiguration.class)) {
            TestBean testBean = context.getBean(TestBean.class);
            System.out.println("Random value: " + testBean.getValue());
        }
    }
}