package icu.jswz.pojo;

import lombok.Data;

/**
 * 用户表
 */

@Data
public class User {
    // 用户id
    private Integer id;
    // 用户名
    private String account;
    // 密码
    private String password;
    // 权限
    private Integer permission;
}
