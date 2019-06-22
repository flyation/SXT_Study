package com.sxt;

/**
 * @author fly
 * @date 2019/6/2
 * 懒汉式
 */
public class SingletonTest02 {
    //类初始化时，不初始化这个对象（延时加载，真正用的时候再创建)。
    private static SingletonTest02 instance;
    //私有化构造器
    private SingletonTest02() {
    }
    //方法同步，调用效率低！
    public static synchronized SingletonTest02 getInstance(){
        if (instance==null){
            instance = new SingletonTest02();
        }
        return instance;
    }
}
