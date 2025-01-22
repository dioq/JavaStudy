package com.base.abstract_study.demo2;

public class Test {
    public static void main(String[] args) throws Throwable {
        MethodBridge.mHook(new Handler() {
            @Override
            public void beforeCall(CallFrame callFrame) throws Throwable {
                super.beforeCall(callFrame);
                System.out.println("------------ beforeCall ------------");
                for (int i = 0; i < callFrame.args.length; i++) {
                    Object arg = callFrame.args[i];
                    System.out.println(i + " : " + arg);
                }
                callFrame.args[0] = "0000";
                callFrame.args[1] = "1111";
                callFrame.args[2] = "2222";
            }

            @Override
            public void afterCall(CallFrame callFrame) throws Throwable {
                super.afterCall(callFrame);
                System.out.println("------------ afterCall ------------");
                for (int i = 0; i < callFrame.args.length; i++) {
                    Object arg = callFrame.args[i];
                    System.out.println(i + " : " + arg);
                }
                Object ret = callFrame.getResult();
                System.out.println("T old ret:" + ret);
                callFrame.setResult("T change value");
            }
        });
    }
}
