package com.attraction.common.entity;

public class ReturnResult {
    private static final String CODE_OK = "200";
    private static final String CODE_ERROR = "500";
    private static final String MSG_OK = "执行成功";
    private static final String MSG_ERROR = "执行失败";

    private String code;
    private String msg;
    private Object data;


    public static ReturnResult ok(){
        return new ReturnResult(CODE_OK, MSG_OK, null);
    }
    public static ReturnResult ok(Object data){
        return new ReturnResult(CODE_OK, MSG_OK, data);
    }
    public static ReturnResult error(){
        return new ReturnResult(CODE_ERROR, MSG_ERROR,null);
    }
    public static ReturnResult error(String message){
        return new ReturnResult(CODE_ERROR, message,null);
    }

    public ReturnResult(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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

    @Override
    public String toString() {
        return "ReturnResult{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
