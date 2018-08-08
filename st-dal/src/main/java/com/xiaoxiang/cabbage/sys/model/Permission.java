package com.xiaoxiang.cabbage.sys.model;

import com.sinco.mybatis.dal.model.BaseModel;

public class Permission extends BaseModel {
    private Long id;

    /** 名称 **/
    private String name;

    /** code **/
    private String code;

    /** 组名称 **/
    private String groupName;

    /** 类型 **/
    private Short userTyep;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Short getUserTyep() {
        return userTyep;
    }

    public void setUserTyep(Short userTyep) {
        this.userTyep = userTyep;
    }
}