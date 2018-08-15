package com.xiaoxiang.cabbage.sys.mapper;

import com.xiaoxiang.cabbage.sys.bo.AdminBO;
import com.xiaoxiang.cabbage.sys.model.Admin;
import com.xiaoxiang.cabbage.sys.model.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<AdminBO> selectByExample(AdminExample example);

    AdminBO selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}