package com.base.ASM.study1;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

    private final static String dir = "src/main/java/com/base/ASM/study1";

    public static void main(String[] args) throws IOException {
//        test1();
//        test2();
        String className = "TargetNew";
        int opcodes = Opcodes.ACC_PUBLIC;
        String methodName = "add";
        String descriptor = "([II])I";
        test2(className, opcodes, methodName, descriptor);
    }

    public static void test2(String className, int opcodes, String methodName, String descriptor) throws IOException {
        // Create a ClassWriter for the class
        ClassWriter classWriter = new ClassWriter(0);

        // Define the class header
        classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, className, null, "java/lang/Object", null);

        // Create the default constructor
//        MethodVisitor constructor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
//        constructor.visitCode();
//        constructor.visitVarInsn(Opcodes.ALOAD, 0);
//        constructor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
//        constructor.visitInsn(Opcodes.RETURN);
//        constructor.visitMaxs(1, 1);
//        constructor.visitEnd();

        // Create the main method
        MethodVisitor mv = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "add", "(II)I", null, null);
        mv.visitCode();
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitInsn(Opcodes.IADD);
        mv.visitInsn(Opcodes.IRETURN);
        // Finalize the class
        classWriter.visitEnd();

        // Write the class to a file
        byte[] byteCode = classWriter.toByteArray();
        File outFile = new File(dir, className + ".class");
        try (FileOutputStream fos = new FileOutputStream(outFile.getPath())) {
            fos.write(byteCode);
        }
    }

    public static void test1() throws IOException {
        // Create a ClassWriter for the class
        ClassWriter classWriter = new ClassWriter(0);

        // Define the class header
        classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "HelloWorld", null, "java/lang/Object", null);

        // Create the default constructor
        MethodVisitor constructor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        constructor.visitCode();
        constructor.visitVarInsn(Opcodes.ALOAD, 0);
        constructor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        constructor.visitInsn(Opcodes.RETURN);
        constructor.visitMaxs(1, 1);
        constructor.visitEnd();

        // Create the main method
        MethodVisitor mainMethod = classWriter.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        mainMethod.visitCode();
        mainMethod.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mainMethod.visitLdcInsn("Hello, World!");
        mainMethod.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        mainMethod.visitInsn(Opcodes.RETURN);
        mainMethod.visitMaxs(2, 1);
        mainMethod.visitEnd();

        // Finalize the class
        classWriter.visitEnd();

        // Write the class to a file
        byte[] byteCode = classWriter.toByteArray();
        File outFile = new File(dir, "HelloWorld.class");
        try (FileOutputStream fos = new FileOutputStream(outFile.getPath())) {
            fos.write(byteCode);
        }
    }
}