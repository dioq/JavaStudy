package com.bytecode.javassist.t2;

public class Window {
    private Box box;
    public boolean widthIs(int w) {
        Point p = box.getSize();
        return w == p.getX();
    }
}
