package com.example.demo_hello_world;

import com.example.demo_hello_world.pojo.Dog;
import com.example.demo_hello_world.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoHelloWorldApplicationTests {
    private Dog dog;
    private Person person;
    @Autowired
    public DemoHelloWorldApplicationTests(Dog dog, Person person) {
        this.dog = dog;
        this.person = person;
    }
    @Test
    void contextLoads() {
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.getHappy());
        System.out.println(person.getBirthday());
        System.out.println(person.getMaps());
        System.out.println(person.getLists());
        System.out.println(person.getDog().getName());
        System.out.println(person.getDog().getAge());
        System.out.println(dog.getName());
        System.out.println(dog.getAge());
    }
}
