package com.my.inner_class;

/*
 * 三、静态内部类
 * 静态内部类也是定义在另一个类里面的类，只不过在类的前面多了一个关键字static。
 * 静态内部类是不需要依赖于外部类的，它不持有指向外部类对象的引用this，并且它不能使用外部类的非static成员或方法，
 * 这点很好理解，因为在没有外部类的对象的情况下，可以创建静态内部类的对象，如果允许访问外部类的非static成员就会产生矛盾，
 * 因为外部类的非static成员必须依附于具体对象。它唯一的作用就是随着类的加载（而不是随着对象的产生）而产生。
 * */
public class Outer6 {

    static class Inner {
        int num = 99;
        public Inner() {
            System.out.println("=== public Inner() ===");
        }
    }

    public static void main(String[] args) {
        Outer6.Inner innner = new Outer6.Inner();
        System.out.println(innner.num);
    }
}
