package com.scu.group8.mailServer.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * 请求结果类
 *
 * @param <T> 数据体类型
 */
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


    public void setResultFailed(String msg) {
        this.message = msg;
        this.isSuccess = false;
        this.data = null;
    }

    public void setIsSuccess(String msg, boolean operationRes) {
        this.message = msg;
        this.isSuccess = operationRes;
        this.data = null;
    }
}
