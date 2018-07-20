package com.szatc.cdm.common.pojo.acdm;

import java.io.Serializable;

/**
 * 返回值及状态说明
 *
 * @author liuweijian
 * @date 2017/12/23
 */
public class Result implements Serializable {
    /**
     * 200：调用正常
     * 500：调用异常
     */
    private int status;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
