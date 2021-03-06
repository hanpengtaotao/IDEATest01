package com.han.simplefactory;

/*
工作的工厂类创建
 */
public class WorkFactory {
    /* 最原始的创建Work类方式
    public IWork create(String workName)
    {
        if("java".equals(workName))
        {
            return new JavaWork();
        }
        else if("cs".equals(workName))
        {
            return new CSWork();
        }
        else {
            return  null;
        }
    }*/

    /*
    //通过使用反射模式创建实体类
    public IWork create(String workClassName) {
        try {
            return (IWork) Class.forName(workClassName).newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }*/

    //通过使用类型约束反射机制进行反射创建实例
    public  IWork create(Class<? extends IWork> work) {
        try {
            if (null != work) {
                return work.newInstance();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
