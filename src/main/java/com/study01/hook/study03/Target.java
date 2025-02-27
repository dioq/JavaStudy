package com.base.hook.study03;

public class Target {

    public Person method1(Person person) {
        System.out.println(person.age);
        Person newPer = new Person();
        newPer.age = person.age - 10;
        return newPer;
    }
}
