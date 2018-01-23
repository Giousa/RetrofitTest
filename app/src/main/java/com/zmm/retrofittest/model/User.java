package com.zmm.retrofittest.model;

import java.io.Serializable;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/1/23
 * Time:上午11:40
 */

public class User implements Serializable{


    /**
     * age : 17
     * id : 100
     * msg : 没有传递任何参数时的测试消息
     * password : 123
     * username : test
     */

    private int age;
    private String id;
    private String msg;
    private String password;
    private String username;

    public User(String username,String password) {
        this.password = password;
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", id='" + id + '\'' +
                ", msg='" + msg + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
