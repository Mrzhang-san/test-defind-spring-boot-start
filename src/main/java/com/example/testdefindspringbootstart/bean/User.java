package com.example.testdefindspringbootstart.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "用户实体")
public class User implements Serializable {
    @ApiModelProperty("用户id")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty("用户姓名")
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty("用户密码")
    private String password;
    /**
     * 创建时间
     */
    @ApiModelProperty("用户创建时间")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}