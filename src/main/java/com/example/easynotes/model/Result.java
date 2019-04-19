package com.example.easynotes.model;

public class Result<T> {
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;
    public Result(T list) {
        this.list = list;
    }
    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }

    private T list;
}
