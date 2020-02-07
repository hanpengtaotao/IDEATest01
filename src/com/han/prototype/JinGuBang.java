package com.han.prototype;

import java.io.Serializable;

/***
 * @desription: TODO
 * @author    : hpt
 * @date      : 2020/1/16 22:29
 */
public class JinGuBang implements Serializable {
    public float d = 100;
    public float h = 10;

    public void big() {
        this.d *= 2;
        this.h *= 2;
    }

    public void small() {
        this.d /= 2;
        this.h /= 2;
    }
}
