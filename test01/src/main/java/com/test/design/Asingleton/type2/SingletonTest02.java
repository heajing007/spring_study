package com.test.design.Asingleton.type2;

import java.util.Objects;

public class SingletonTest02 {
}

/**
 * 懒加载
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
 *  双重检查
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