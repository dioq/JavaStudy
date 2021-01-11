package com.my.inner_class;

/*
 * 二、局部内部类
 * 局部内部类是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别在于局部内部类的访问仅限于方法内或者该作用域内。
 * 局部内部类就像方法里面的局部变量一样，是不能有public、protected、private及static修饰符的。
 * */
public class Outer5 {
    private int num = 1;
    private int num1 = 10;

    public void func() {
        class Inner {
            private int num = 2;
        }
        Inner inner = new Inner();
        System.out.println(inner.num);
    }

    public static void main(String[] args) {
        Outer5 outer = new Outer5();
        outer.func();
    }
}
