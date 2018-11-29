package com.github.wenslo.springbootdemo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月24日 下午4:04
 * @description
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response implements Serializable {
    private static final int SUCCESS_CODE = 200;
    private static final int ERROR_CODE = 500;
    private static final int UNAUTHORIZED_CODE = 401;
    private static final String SUCCESS_MSG = "成功";
    private static final String ERROR_MSG = "失败";
    private static final String UNAUTHORIZED_MSG = "未授权";
    private static final long serialVersionUID = -5469984823575289643L;
    private int code;
    private String msg;
    private Object data;

    private Response(int code, String msg) {
        this(code, msg, null);
    }

    public Response(int code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /** 操作成功 **/
    public static final Response SUCCESS = new Response(SUCCESS_CODE, SUCCESS_MSG);
    /** 操作失败 **/
    public static final Response ERROR = new Response(ERROR_CODE, ERROR_MSG);
    public static final Response UNAUTHORIZED = new Response(UNAUTHORIZED_CODE, UNAUTHORIZED_MSG);

    public static Response success(Object data) {
        return new Response(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    public static Response error(String msg) {
        return new Response(ERROR_CODE, msg);
    }

    public static Response error(int code, String msg) {
        return new Response(code, msg);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"code\":")
                .append(code);
        sb.append(",\"msg\":\"")
                .append(msg).append('\"');
        sb.append(",\"data\":")
                .append(data);
        sb.append('}');
        return sb.toString();
    }
}
