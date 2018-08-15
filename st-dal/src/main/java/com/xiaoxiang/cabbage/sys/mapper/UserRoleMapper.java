package com.xiaoxiang.cabbage.sys.mapper;

import com.xiaoxiang.cabbage.sys.bo.UserRoleBO;
import com.xiaoxiang.cabbage.sys.model.UserRole;
import com.xiaoxiang.cabbage.sys.model.UserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    long countByExample(UserRoleExample example);

    int deleteByExample(UserRoleExample example);

    int deleteByPrimaryKey(@Param("userId") Long userId, @Param("roleId") Long roleId);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRoleBO> selectByExample(UserRoleExample example);

    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleExample example);
}