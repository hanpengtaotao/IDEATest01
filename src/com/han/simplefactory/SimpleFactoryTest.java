package com.han.simplefactory;


/***
 * 简单工厂模式，其他模式其中
 * 创建型模式：工厂模式、单例模式、原型模式
 * 结构型模式：适配器模式、装饰者模式、代理模式
 * 行为型模式：策略模式、模板模式、委派模式、观察者模式
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        WorkFactory workFactory = new WorkFactory();
        //IWork cs = workFactory.create("cs");
        //IWork cs=workFactory.create("com.han.simplefactory.JavaWork");
        IWork cs=workFactory.create(JavaWork.class);
        cs.createCode();
    }
}
