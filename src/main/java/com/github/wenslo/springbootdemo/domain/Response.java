package com.github.wenslo.springbootdemo.domain;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月24日 下午4:04
 * @description
 */
public class Response implements Serializable {
    private int code;
    private String msg;
    private Object data;

    public Response(int code, String msg) {
        this(code, msg, null);
    }

    public Response(int code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static final String LOGIN_FAIL_MSG = "username or password is error,try again please";

    public static final Response SUCCESS = new Response(OK.value(), OK.getReasonPhrase());
    public static final Response ERROR = new Response(INTERNAL_SERVER_ERROR.value(), INTERNAL_SERVER_ERROR.getReasonPhrase());
    public static final Response UNAUTHORIZED = new Response(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
    public static final Response LOGIN_FAIL = new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), LOGIN_FAIL_MSG);

    public static Response success(Object data) {
        return new Response(OK.value(), OK.getReasonPhrase(), data);
    }

    public static Response error(String msg) {
        return new Response(INTERNAL_SERVER_ERROR.value(), msg);
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
