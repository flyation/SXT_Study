package com.sxt;

/**
 * @author fly
 * @date 2019/6/2
 * 饿汉式
 */
public class SingletonTest01 {
    //类初始化时，立即加载这个对象（没有延时加载的优势）。加载类时，是天然的线程安全的！
    private static SingletonTest01 instance = new SingletonTest01();
    //私有化构造器
    private SingletonTest01() {
    }
    //方法没有同步，调用效率高！
    public static SingletonTest01 getInstance(){
        return instance;
    }
}
