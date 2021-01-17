package com.my.reference;

public class ObjectTest05 {

    public static Student changeValue(Student stu) {
        System.out.println("changeValue stu.hashCode() : " + stu.hashCode());
        System.out.println("111 changeValue : " + stu.toString());
        stu.age = 20;
        System.out.println("222 changeValue : " + stu.toString());
        return stu;
    }

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println("student.hashCode() : " + student.hashCode());
        Student stu = new Student();
        stu.name = "name1";
        stu.age = 18;

        System.out.println("stu.hashCode() : " + stu.hashCode());
        System.out.println("111 stu.toString() : " + stu.toString());
        Student stu2 = changeValue(stu);
        System.out.println("222 stu.toString() : " + stu.toString());
        System.out.println("stu2.hashCode() : " + stu2.hashCode());
        System.out.println("stu2.toString() : " + stu2.toString());
    }
}
