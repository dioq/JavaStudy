package com.base.abstract_study.demo2;

import java.lang.reflect.Member;

public class CallFrame {

    /**
     * The calling method.
     */
    public Member method;

    /**
     * The "this" object of this call, {@code null} if executing a static method.
     * Change it in {@code beforeCall} to set new object as "this" when calling original method.
     */
    public Object thisObject;

    /**
     * The arguments passed to the method in this call. Will never be null.
     * Change it or its value in {@code beforeCall} to change arguments when calling original method.
     */
    public Object[] args;
    private Object result;
    private Throwable throwable;
    /* package */ boolean returnEarly;

    public CallFrame(Object[] args) {
//        this.thisObject = thisObject;
        this.args = args;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
        this.throwable = null;
        this.returnEarly = true;
    }

    public void setResultIfNoException(Object result) {
        if (this.throwable == null) {
            this.result = result;
            this.returnEarly = true;
        }
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public boolean hasThrowable() {
        return throwable != null;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
        this.result = null;
        this.returnEarly = true;
    }

    public Object getResultOrThrowable() throws Throwable {
        if (throwable != null)
            throw throwable;
        return result;
    }

    public void resetResult() {
        this.result = null;
        this.throwable = null;
        this.returnEarly = false;
    }
}
