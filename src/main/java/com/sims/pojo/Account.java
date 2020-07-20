package com.sims.pojo;

import javax.xml.crypto.Data;
import java.util.Date;

public class Account {
    private Integer a_id;
    private String a_name;
    private Integer a_gender;
    private Date a_birthday;
    private String a_user;
    private String a_password;
    private Integer a_major_id;
    private String a_create_user;
    private Date a_create_date;
    private String a_modify_user;
    private Date a_modfify_date;  // 11

    private Integer age ; //计算得出
    private String major_name; //专业名称 连表 13

    public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public Integer getA_gender() {
        return a_gender;
    }

    public void setA_gender(Integer a_gender) {
        this.a_gender = a_gender;
    }

    public Date getA_birthday() {
        return a_birthday;
    }

    public void setA_birthday(Date a_birthday) {
        this.a_birthday = a_birthday;
    }

    public String getA_user() {
        return a_user;
    }

    public void setA_user(String a_user) {
        this.a_user = a_user;
    }

    public String getA_password() {
        return a_password;
    }

    public void setA_password(String a_password) {
        this.a_password = a_password;
    }

    public Integer getA_major_id() {
        return a_major_id;
    }

    public void setA_major_id(Integer a_major_id) {
        this.a_major_id = a_major_id;
    }

    public String getA_create_user() {
        return a_create_user;
    }

    public void setA_create_user(String a_create_user) {
        this.a_create_user = a_create_user;
    }

    public Date getA_create_date() {
        return a_create_date;
    }

    public void setA_create_date(Date a_create_date) {
        this.a_create_date = a_create_date;
    }

    public String getA_modify_user() {
        return a_modify_user;
    }

    public void setA_modify_user(String a_modify_user) {
        this.a_modify_user = a_modify_user;
    }

    public Date getA_modfify_date() {
        return a_modfify_date;
    }

    public void setA_modfify_date(Date a_modfify_date) {
        this.a_modfify_date = a_modfify_date;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }
}
