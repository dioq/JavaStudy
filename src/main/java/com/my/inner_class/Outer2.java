package com.my.inner_class;

public class Outer2 {
    private int num = 1;

    //它包含有一个对外部类的this指针，从而可以访问外部类的所有元素，包括所有public/private的成员和方法
    public class Inner {
        private int num = 2;

        private void func() {
            System.out.println(Outer2.this.num);
        }
    }

    public static void main(String[] args) {
        Outer2 outer = new Outer2();
        Inner inner = outer.new Inner();
        inner.func();
    }
}
