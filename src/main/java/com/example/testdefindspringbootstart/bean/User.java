package com.example.testdefindspringbootstart.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "用户实体")
@Entity
@NoArgsConstructor
@Data
@Table(name = "user")
public class User implements Serializable {

    @ApiModelProperty("用户id")
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 用户名
     */
    @ApiModelProperty("用户姓名")
    @NotNull(message = "姓名不能为空")
    private String userName;
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

    private Integer age;

    public User(String username, Integer age) {
        this.userName = username;
        this.age = age;
    }
}