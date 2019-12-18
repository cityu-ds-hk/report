package edu.cityu.ds.report.entity;


import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(description = "Result Entity")
public class Result {
    
//    @ApiModelProperty("result status")
    private int status;
    
//    @ApiModelProperty("result code")
    private String code;
    
//    @ApiModelProperty("result message")
    private String message;
    
//    @ApiModelProperty("result created time")
    private long timestamp = new Date().getTime();
    
//    @ApiModelProperty("result data")
    private Object data;

    public Result(int status, String code, String message, Object data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", data=" + data +
                '}';
    }
}
