package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person (String name, int age, Address address) {};
record Address (String firstLine, String city) {};

@Configuration // 이걸로 spring beans 관리가능, spring에서 관리하는 것들을 spring beans 라고 함
public class HelloWorldConfiguration {
    @Bean
    public String name() {
        return "Ranga";
    }
    @Bean
    public int age() {
        return 24;
    }
    @Bean
    public Person person() {
        return new Person("Ravi", 20, new Address("Main", "Um"));
    }
    @Bean
    public Person person2MethodCall() { // 메소드로 주입
        return new Person(name(), age(), address()); // name, age
    }
    @Bean
    public Person person3Parameters(String name, int age, Address address3) { // name, age, address2, 파라미터로 주입
        return new Person(name, age, address3); // name, age
    }
    @Bean
    @Primary
    public Person person4Parameters(String name, int age, Address address) { // name, age, address2, 파라미터로 주입
        return new Person(name, age, address); // name, age
    }
    @Bean
    public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) { // name, age, address2, 파라미터로 주입
        return new Person(name, age, address); // name, age
    }

    @Bean(name = "address2")
    @Primary
    public Address address() {
        return new Address("GwangJu", "Chumdan");
    }
    @Bean(name = "address3")
    @Qualifier("address3qualifier")
    public Address address3() {
        return new Address("Sinan", "Chunsik");
    }
}
