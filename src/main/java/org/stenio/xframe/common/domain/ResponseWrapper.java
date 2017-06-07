package org.stenio.xframe.common.domain;

import java.io.Serializable;

/**
 * Created by bjhexin3 on 2017/6/7.
 */
public class ResponseWrapper<T> implements Serializable {

    private static final long serialVersionUID = 450987146805502229L;

    private int code = 200;

    private String message = "";

    private T data;

    public ResponseWrapper() {
    }

    public ResponseWrapper(T data) {
        this.data = data;
    }

    public ResponseWrapper(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
