package com.test.design.Asingleton.type2;

import java.util.Objects;

public class SingletonTest02 {
}

/**
 * 懒汉式（线程不安全
 */
class Singleton1{
    private static Singleton1 instance;

    private Singleton1(){

    }

    public static Singleton1 getInstance(){
        if (Objects.isNull(instance)){
            instance = new Singleton1();
        }
        return instance;
    }
}

/**
 * 懒汉式 双重检查（线程安全
 */
class Singleton2{
    private static volatile Singleton2 instance;

    private Singleton2(){

    }

    public static Singleton2 getInstance(){
        if (Objects.isNull(instance)){
            synchronized (Singleton2.class){
                if (Objects.isNull(instance)){
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}

/**
 * 静态内部类（线程安全
 */
class Singleton3{

    private Singleton3(){

    }

    private static class Singleton3Instance{
        private static final Singleton3 INSTANCE = new Singleton3();
    }

    private Singleton3 getInstance(){
        return Singleton3Instance.INSTANCE;
    }
}

enum Singleton4{
    INSTANCE;
}