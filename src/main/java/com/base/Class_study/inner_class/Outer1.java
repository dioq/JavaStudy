package com.base.Class_study.inner_class;

public class Outer1 {
    private int num = 1;

    /*
     * 一般的类是不允许用private修饰符的，但是内部类却可以，该实例中，类Inner只对Outer可见，其他的类无法访问的到Inner类。
     * 注意，这里有个例外，如果内部类的访问修饰符被设定为public，那么它是可以被其他类使用的，但是必须经由外部类来实例化内部类。
     * */
    public class Inner {
        private int num = 2;
    }

    public static void main(String[] args) {
        Outer1 outer1 = new Outer1();
        Outer1.Inner inner = outer1.new Inner();
        System.out.println(inner.num);
    }

}
