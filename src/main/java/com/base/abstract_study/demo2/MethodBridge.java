package com.base.abstract_study.demo2;

public class MethodBridge {

    public static void mHook(Handler handler) throws Throwable {
        Object[] args = new Object[]{"mAAAA", "mBBBB", "mCCCC"};
        CallFrame callFrame = new CallFrame(args);
        callFrame.setResult("m return value");
        handler.beforeCall(callFrame);
        System.out.println("----------- mHook 1 -----------");
        for (int i = 0; i < callFrame.args.length; i++) {
            Object arg = callFrame.args[i];
            System.out.println(i + " : " + arg);
        }

        Object ret = callFrame.getResult();
        System.out.println("m old ret:" + ret);


        handler.afterCall(callFrame);

        System.out.println("----------- mHook 2 -----------");
        for (int i = 0; i < callFrame.args.length; i++) {
            Object arg = callFrame.args[i];
            System.out.println(i + " : " + arg);
        }

        Object ret2 = callFrame.getResult();
        System.out.println("m 2 ret:" + ret2);
    }
}
