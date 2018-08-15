package com.xiaoxiang.cabbage.sys.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class Permission extends BaseModel {
    private Long id;

    /** 名称 **/
    private String name;

    /** code **/
    private String value;

    /** 组名称 **/
    private String groupName;

    private Date createTime;

    /** 类型 **/
    private Integer userType;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}