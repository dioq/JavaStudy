package com.bytecode.ASM.study1;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.bytecode.ASM.MyClassLoader;

public class Test {
    private final static String outDir = "/Users/lzd/repository/JavaStudy/src/main/java/com/base/ASM/study1";

    private final static String className = "User";

    public static void main(String[] args) throws Exception {
//        test1();
        test2();
    }

    public static void test1() throws Exception {
        // 创建 ClassWriter，用于生成类的字节码
        ClassWriter classWriter = new ClassWriter(0);

//        String pkg = "com/base/ASM";
//        String classNameFull = pkg + "/" + className;
        // 定义类的基本信息（版本号、访问标志、类名、签名、父类、接口）
        classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, className, null, "java/lang/Object", null);

        // 创建默认构造方法
        MethodVisitor constructor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        constructor.visitCode();
        constructor.visitVarInsn(Opcodes.ALOAD, 0);
        constructor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        constructor.visitInsn(Opcodes.RETURN);
        constructor.visitMaxs(1, 1);
        constructor.visitEnd();

        // 创建 add 方法
        MethodVisitor addMethod = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "add", "(II)I", null, null);
        addMethod.visitCode();
        // 将第一个参数加载到操作数栈
        addMethod.visitVarInsn(Opcodes.ILOAD, 1);
        // 将第二个参数加载到操作数栈
        addMethod.visitVarInsn(Opcodes.ILOAD, 2);
        // 执行加法操作
        addMethod.visitInsn(Opcodes.IADD);
        // 返回加法结果
        addMethod.visitInsn(Opcodes.IRETURN);
        // 设置操作数栈和局部变量表的最大尺寸
        addMethod.visitMaxs(2, 3);
        addMethod.visitEnd();

        // 完成类的生成
        classWriter.visitEnd();

        // 将生成的类字节码写入文件
        byte[] byteCode = classWriter.toByteArray();
        File outFile = new File(outDir, className + ".class");
        FileOutputStream fos = new FileOutputStream(outFile.getPath());
        fos.write(byteCode);
        fos.close();
    }

    public static void test2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        MyClassLoader classLoader = new MyClassLoader(outDir);
        Class<?> clazz = classLoader.loadClass("User");
        if (clazz == null) {
            System.out.println("clazz is null!");
            return;
        }
        Object obj = clazz.getDeclaredConstructor().newInstance();

        int a = 10, b = 20;
        Method method = clazz.getDeclaredMethod("add", int.class, int.class);
        int result = (int) method.invoke(obj, a, b);
        System.out.println("result:" + result);
    }
}
