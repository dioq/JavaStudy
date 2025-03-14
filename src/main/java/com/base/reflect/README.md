# 反射

在运行状态中,对任意一个类,都能知道这个类中所有的属性和方法;对于任意一个对象,都能调用它的任意一个方法和属性。

## 类的加载过程

类的加载是指将指定的Class文件的二进制数据,加载到JVM的方法区中,并在堆区中创建对应的Class对象,该过程主要分为以下几步：

装载：查找并导入对应的Class文件到JVM中
链接： (1)检查：检查载入的class文件数据的正确性和完整性
      (2)准备：给类的静态变量分配存储空间
      (3)解析：将常量池中的符号引用转化为直接引用
初始化：对静态变量、静态代码块执行初始化工作

## 获取类

forName()方法是Class类中的静态方法,loadClass是ClassLoader类中的静态方法,它们的作用都是用于显式的加载Class文件,以下是两种方法的用法：
Class.forName("ClassName");
ClassLoader.loadClass("ClassName");
理想中,两种方法的结果都是将指定限定名的Class文件加载到JVM内存中,那么到底它们之间有什么细微区别？

当我们调用 Class.forName("ClassName") 方法的时候,实际上是调用了一个重载方法Class.forName("ClassName",true,ClassLoader.getClassLoader()) 。
ClassName：指定需要加载的类的全限定名
true：表示被加载的Class文件需要执行初始化步骤
ClassLoader.getClassLoader()：对应的类加载器
因此我们不难发现,重点在于第二个参数 true,它使得使用 Class.forName("ClassName") 进行加载的Class文件会执行初始化步骤,也就是对静态变量、静态代码块的初始化。

而当我们调用 ClassLoader.loadClass("ClassName") 方法的时候,实际上也是调用了一个重载方法ClassLoader.loadClass("ClassName",false) 。
此我们不难发现,重点也在于第二个参数 flase,它的意思是表示不需要执行链接步骤,它使得使用 ClassLoader.loadClass("ClassName") 进行加载的Class文件不会执行链接步骤,自然也不会初始化步骤,因此它并没有对静态变量、静态代码块进行初始化。
