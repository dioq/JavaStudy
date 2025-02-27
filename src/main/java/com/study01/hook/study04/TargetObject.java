package com.base.hook.study04;

public class TargetObject implements DoTask {
    @Override
    public void doSomething() {
        System.out.println("Do a task!");
    }
}
