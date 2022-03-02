package com.scu.group8.mailServer.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class Result<T> implements Serializable {
    private String message;
    private boolean isSuccess;
    private T data;

    public void setResultSuccess(String msg, T data) {
        this.message = msg;
        this.isSuccess = true;
        this.data = data;
    }

    public void setResultSuccess(String msg) {
        this.message = msg;
        this.isSuccess = true;
        this.data = null;
    }

    public void setResultFailed(String msg) {
        this.message = msg;
        this.isSuccess = false;
        this.data = null;
    }

}
