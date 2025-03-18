package com.base.Class_study.inner_class;

/*
 * 一、成员内部类
 * 当某个类除了他的外部类，不会被其他类使用时，使用成员内部类。这种情况下，内部类依附于外部类而存在，原因可能有： 1. 不可能有其他类使用该内部类。 2. 该内部类不能被其他类使用，可能会导致错误。这是内部类使用比较多的一个场景。
 * 1) 外部类可以直接访问内部类的成员和方法，但是必须先创建一个内部类的对象，再通过该对象使用其成员和方法。
 * 2) 内部类可以访问外部类的成员和方法，但是要注意，当内部类拥有和外部类相同的成员或方法时，会发生隐藏现象，默认情况下访问的是成员内部类的成员。如果要访问外部类的同名成员，需要以下面的形式访问：外部类.this.成员变量/方法
 * 3) 内部类只是一个编译时的概念，一旦编译成功，就会成为完全不同的两个类。对于一个名为Outer的外部类和其内部定义的名为Inner的内部类，编译完后会生成Outer.class和Outer$Inner.class两个类
 * 4) 成员内部类与普通的成员没什么区别，可以与普通成员一样进行修饰和限制
 * */
public class Outer4 {
    private int num = 1;
    private int num1 = 10;

    public class Inner {
        private int num = 2;

        public void func() {
            System.out.println(Outer4.this.num);
            System.out.println(num1);
        }
    }

    public static void main(String[] args) {
        Outer4 outer = new Outer4();
        Inner inner = outer.new Inner();
        inner.func();
    }
}
