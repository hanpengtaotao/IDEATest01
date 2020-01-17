package com.han.prototype;

/**
 * @author HPT
 * @version 1.0
 * @package com.han.prototype
 * @date 2020/1/17 0017 13:50
 */
public class PrototypeTest1 {
    public  static void main(String[] args) {
        AAA aaa = new AAA();
        AAA aaa1 = aaa.clone();

        aaa1.getAaaTest().setName("han");

        System.out.println(aaa.getAaaTest().hashCode() + ":" + aaa1.getAaaTest().hashCode());
        System.out.println(aaa.getAaaTest().getName() + ":" + aaa1.getAaaTest().getName());
    }
}

class AAA implements Cloneable {
    private AAATest aaaTest;

    public AAA() {
        aaaTest = new AAATest();
        System.out.println("初始化AAA");
    }

    public AAATest getAaaTest() {
        return aaaTest;
    }

    public void setAaaTest(AAATest aaaTest) {
        this.aaaTest = aaaTest;
    }

    @Override
    protected AAA clone() {
        AAA aaa = null;
        try {
            aaa = (AAA) super.clone();
            //aaa.aaaTest = new AAATest();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return aaa;
    }
}

class  AAATest
{
    private String name;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
