package com.itheima.controller.utils;

import lombok.Data;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author CDUY
 * @version 1.0
 */
@Data
public class R {
    private Boolean flag;
    private Object data;

    public R() { }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}
