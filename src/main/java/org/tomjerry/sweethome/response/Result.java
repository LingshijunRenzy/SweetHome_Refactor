package org.tomjerry.sweethome.response;

/**
 * 这个类定义了一个通用的返回结果类，用于返回操作结果
 * @param <T> 返回结果的类型
 */
public class Result <T>{
    private Integer code;       // 返回结果的状态码
    private String message;     // 返回结果的消息
    private T data;             // 返回结果的数据

    public Result() {
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
