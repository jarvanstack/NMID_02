package com.sims.pojo;

import javax.xml.crypto.Data;

public class Major {
    private Integer m_id;
    private Integer m_major_id;
    private String m_name;
    private String m_desc;
    private Integer m_stu_count;
    private String m_create_user;
    private Data m_create_date;
    private String m_modify_user;
    private Data m_modify_date; // 9

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public Integer getM_major_id() {
        return m_major_id;
    }

    public void setM_major_id(Integer m_major_id) {
        this.m_major_id = m_major_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_desc() {
        return m_desc;
    }

    public void setM_desc(String m_desc) {
        this.m_desc = m_desc;
    }

    public Integer getM_stu_count() {
        return m_stu_count;
    }

    public void setM_stu_count(Integer m_stu_count) {
        this.m_stu_count = m_stu_count;
    }

    public String getM_create_user() {
        return m_create_user;
    }

    public void setM_create_user(String m_create_user) {
        this.m_create_user = m_create_user;
    }

    public Data getM_create_date() {
        return m_create_date;
    }

    public void setM_create_date(Data m_create_date) {
        this.m_create_date = m_create_date;
    }

    public String getM_modify_user() {
        return m_modify_user;
    }

    public void setM_modify_user(String m_modify_user) {
        this.m_modify_user = m_modify_user;
    }

    public Data getM_modify_date() {
        return m_modify_date;
    }

    public void setM_modify_date(Data m_modify_date) {
        this.m_modify_date = m_modify_date;
    }
}
