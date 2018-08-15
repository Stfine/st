package com.xiaoxiang.cabbage.sys.model;

import com.sinco.mybatis.dal.model.BaseModel;

public class UserRole extends BaseModel {
    private Long userId;

    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}