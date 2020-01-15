package com.han.prototype;

/***
 * 原型模式是指原型实例指定创建对象的种类，并且通过复制这些原型创建新的对象
 * 原型模式适用场景
 * 1、类初始化消耗资源较多
 * 2、使用new创建一个对象需要非常繁琐的过程稿（数据准备、访问权限等）
 * 3、构造函数比较复杂
 * 4、在循环体中产生大量对象
 */

public interface Prototype {
    Prototype clone();
}
