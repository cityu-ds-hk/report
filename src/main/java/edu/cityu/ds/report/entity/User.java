package edu.cityu.ds.report.entity;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "User Entity")
public class User {
    
//    @ApiModelProperty("user id")
    private int userId;
    
//    @ApiModelProperty("user name")
    private String userName;
    
//    @ApiModelProperty("user password")
    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
