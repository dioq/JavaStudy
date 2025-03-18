package com.base.Class_study.inner_class;

/*
 * 四、匿名内部类
 * 匿名内部类应该是平时我们编写代码时用的最多的，在编写事件监听的代码时匿名内部类不但方便，而且使代码更加容易维护。
 * 匿名内部类是唯一一种没有构造器的类。正因为其没有构造器，所以匿名内部类的使用范围非常有限，大部分匿名内部类用于接口回调。
 * 匿名内部类在编译的时候由系统自动起名为Outer$1.class。一般来说，匿名内部类用于集成其他类或者实现接口，
 * 并不需要增加额外的方法，只是对集成方法的实现或是重写。
 * */
public class Outer7 {

    /**
     * 包含两个方法的HelloWorld接口
     */
    interface HelloWorld {
        public void greet();

        public void greetSomeone(String someone);
    }

    public void sayHello() {

        // 1、局部类EnglishGreeting实现了HelloWorld接口
        class EnglishGreeting implements HelloWorld {
            String name = "world";

            public void greet() {
                greetSomeone("world");
            }

            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }

        HelloWorld englishGreeting = new EnglishGreeting();

        // 2、匿名类实现HelloWorld接口
        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";

            public void greet() {
                greetSomeone("tout le monde");
            }

            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };

        // 3、匿名类实现HelloWorld接口
        HelloWorld spanishGreeting = new HelloWorld() {
            String name = "mundo";

            public void greet() {
                greetSomeone("mundo");
            }

            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }
        };

        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
        spanishGreeting.greet();
    }

    public static void main(String... args) {
        Outer7 myApp = new Outer7();
        myApp.sayHello();
    }

}

/*
 * 总结：
 * 1. 每个内部类都能独立的集成一个接口的实现，所以无论外部类是否已经集成了某个（接口）实现，对于内部类都没有影响。内部类使得多重集成的解决方案变得完整。
 * 2. 方便将存在一定逻辑关系的类组织在一起，又可以对外界隐藏。
 * 3. 方便编写时间驱动程序。
 * 4. 方便编写线程代码。
 * */
