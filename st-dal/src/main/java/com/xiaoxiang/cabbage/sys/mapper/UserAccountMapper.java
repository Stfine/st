package com.xiaoxiang.cabbage.sys.mapper;

import com.xiaoxiang.cabbage.sys.bo.UserAccountBO;
import com.xiaoxiang.cabbage.sys.model.UserAccount;
import com.xiaoxiang.cabbage.sys.model.UserAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAccountMapper {
    long countByExample(UserAccountExample example);

    int deleteByExample(UserAccountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserAccount record);

    int insertSelective(UserAccount record);

    List<UserAccountBO> selectByExample(UserAccountExample example);

    UserAccountBO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserAccount record, @Param("example") UserAccountExample example);

    int updateByExample(@Param("record") UserAccount record, @Param("example") UserAccountExample example);

    int updateByPrimaryKeySelective(UserAccount record);

    int updateByPrimaryKey(UserAccount record);
}