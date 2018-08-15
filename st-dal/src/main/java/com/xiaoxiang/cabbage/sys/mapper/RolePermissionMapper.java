package com.xiaoxiang.cabbage.sys.mapper;

import com.xiaoxiang.cabbage.sys.bo.RolePermissionBO;
import com.xiaoxiang.cabbage.sys.model.RolePermission;
import com.xiaoxiang.cabbage.sys.model.RolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionMapper {
    long countByExample(RolePermissionExample example);

    int deleteByExample(RolePermissionExample example);

    int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    List<RolePermissionBO> selectByExample(RolePermissionExample example);

    int updateByExampleSelective(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    int updateByExample(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);
}