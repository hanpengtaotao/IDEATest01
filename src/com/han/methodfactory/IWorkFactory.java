package com.han.methodfactory;

import com.han.simplefactory.IWork;

/*
定义创建工厂类型接口
 */
public interface IWorkFactory {
    IWork create();
}
