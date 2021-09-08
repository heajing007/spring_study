package com.test.design.Asingleton.type1;

public class SingletonTest01 {
    public static void main(String[] args) {

    }


}

/**
 * 饿汉式（静态变量）
 */
class Singleton1{
    private Singleton1(){

    }
    private final static Singleton1 instance = new Singleton1();

    public static Singleton1 getInstance(){
        return instance;
    }
}

/**
 * 饿汉式（静态代码块）
 */
class Singleton2{
    private Singleton2(){
    }
    private static Singleton2 instance;

    static {
        instance = new Singleton2();
    }

    public static Singleton2 getInstance(){
        return instance;
    }
}
