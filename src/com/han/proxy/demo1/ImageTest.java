package com.han.proxy.demo1;

/**
 * @author HPT
 * @version 1.0
 * @package com.han.proxy.demo1
 * @date 2020/1/17 0017 14:18
 */
public class ImageTest {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();
    }
}
