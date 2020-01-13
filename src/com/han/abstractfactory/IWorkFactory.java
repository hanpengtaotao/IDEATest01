package com.han.abstractfactory;

/***
 * 工厂类接口
 */
public interface IWorkFactory {
    ICode createCode();
    IHelpDoc createHelpDoc();
}
