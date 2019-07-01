package com.sxt;

/**
 * @author fly
 * @date 2019/6/22
 * 双重监测锁式
 * 由于JVM底层内部模型原因，偶尔会出问题，不建议使用。
 */
public class SingletonTest03 {
    private static class SingletonClassInstance{
        private static final SingletonTest03 instance = new SingletonTest03();
    }

    //私有化构造器
    private SingletonTest03() {
    }

    public static SingletonTest03 getInstance(){
        return SingletonClassInstance.instance;
    }
}
