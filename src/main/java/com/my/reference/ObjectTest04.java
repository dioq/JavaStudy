package com.my.reference;

public class ObjectTest04 {

    public static void changeValue(Student stu) {
        System.out.println("changeValue : " + stu.hashCode());
        System.out.println("111 changeValue : " + stu.toString());
        stu.age = 20;
        System.out.println("222 changeValue : " + stu.toString());
    }

    public static void main(String[] args) {
        Student stu = new Student();
        stu.name = "name1";
        stu.age = 18;
        System.out.println("main : " + stu.hashCode());
        System.out.println("111 main : " + stu.toString());
        changeValue(stu);
        System.out.println("222 main : " + stu.toString());
    }
}
