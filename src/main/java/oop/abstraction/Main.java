package oop.abstraction;

abstract class A {

    A() {
        show();
    }

    abstract void show();
}

class B extends A {

    private int value = 10;

    @Override
    void show() {
        System.out.println(value);
    }
}

public class Main {

    public static void main(String[] args) {
        A obj = new B();
        obj.show();
    }
}
