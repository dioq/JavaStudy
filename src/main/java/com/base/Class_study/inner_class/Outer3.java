package com.base.Class_study.inner_class;

public class Outer3 {
    private int num = 1;

    //外部类对内部类的所有元素也都有访问权，包括内部类的私有成员和方法：
    public class Inner {
        private int num = 2;
    }

    public void func() {
        Inner inner = new Inner();
        System.out.println(inner.num);
    }

    public static void main(String[] args) {
        Outer3 outer = new Outer3();
        outer.func();    // 2
    }
}
