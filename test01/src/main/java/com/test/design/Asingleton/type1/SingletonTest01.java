package com.test.design.Asingleton.type1;

public class SingletonTest01 {
    public static void main(String[] args) {

    }


}

/**
 * 饿汉式（静态变量）
 */
class Singleton{
    private Singleton(){

    }
    private final static Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }
}
