package edu.zju.cst.js.entity;

import java.util.List;

/**
 * 类功能描述
 *
 * @Author rowe
 * @Date 2020/1/7 9:52
 */

public class ResponseData<T> {
    private int code = 0;
    private String msg = "";
    private int count;
    private List<T> data;

    public ResponseData(List<T> data){
        this.data = data;
        this.count = data.size();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
