package com.springboot.common;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/24 14:43
 * @Version 1.0
 */
public class ResultMsg {

    private Integer code;

    private String msg;

    private Object data;

    public ResultMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultMsg(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
