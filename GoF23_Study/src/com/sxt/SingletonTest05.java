package com.sxt;

/**
 * @author fly
 * @date 2019/6/22
 * 枚举式
 * 无延迟加载，并且天然防止反射和反序列化漏洞。
 */
public enum  SingletonTest05 {
    INSTANCE;

    public void SingletonOperation(){
        //自定义操作
    }
}
