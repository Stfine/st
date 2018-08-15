package com.xiaoxiang.cabbage.sys.mapper;

import com.xiaoxiang.cabbage.sys.bo.RoleBO;
import com.xiaoxiang.cabbage.sys.model.Role;
import com.xiaoxiang.cabbage.sys.model.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    List<RoleBO> selectByExample(RoleExample example);

    RoleBO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}