package com.zte.ums.entity.vo;

/**
 * Author:hellboy
 * Date:2018-10-29 15:20
 * Description:<描述>
 * 该对象用于封装需要绑定的数据，不一定是一张表中的数据
 */

public class UserVO {

    private String username;

    private String password;

    private Integer age;

    //班级

    //课程


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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
