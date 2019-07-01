package com.sxt;

/**
 * @author fly
 * @date 2019/6/22
 * 静态内部类式
 * 线程安全，调用效率高，并且实现了延迟加载！
 */
public class SingletonTest04 {
    private static class SingletonClassInstance{
        private static final SingletonTest04 instance = new SingletonTest04();
    }

    //私有化构造器
    private SingletonTest04() {
    }

    public static SingletonTest04 getInstance(){
        return SingletonClassInstance.instance;
    }
}
