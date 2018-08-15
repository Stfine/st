package com.xiaoxiang.cabbage.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.xiaoxiang.cabbage.sys.mapper.UserRoleMapper;
import com.xiaoxiang.cabbage.sys.model.UserRole;
import com.xiaoxiang.cabbage.sys.bo.UserRoleBO;
import com.xiaoxiang.cabbage.sys.model.UserRoleExample;

@Repository
public class UserRoleDao {

	@Autowired
	private UserRoleMapper mapper;


   /** generate code begin**/
	public List<UserRoleBO> findAll(){
		UserRoleExample example=new UserRoleExample();
		return mapper.selectByExample(example);
	}
	
	public long count(){
		UserRoleExample example=new UserRoleExample();
		return mapper.countByExample(example);
	}

	public List<UserRole> save(Iterable<UserRole> entities){
		List<UserRole> list=new ArrayList<UserRole>();
		for (UserRole UserRole : entities) {
			list.add(save(UserRole));
		}
		return list;
	}
	
	public UserRole save(UserRole record){
		
		mapper.insertSelective(record);
		
		return record;
	}
	

	public List<UserRoleBO> findByUserId(java.lang.Long userId){
		UserRoleExample example=new UserRoleExample();
		example.createCriteria().andUserIdEqualTo(userId);
		return mapper.selectByExample(example);
	}
	
	public int deleteByUserId(java.lang.Long userId){
		UserRoleExample example=new UserRoleExample();
		example.createCriteria().andUserIdEqualTo(userId);
		return mapper.deleteByExample(example);
	}
	public List<UserRoleBO> findByRoleId(java.lang.Long roleId){
		UserRoleExample example=new UserRoleExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		return mapper.selectByExample(example);
	}
	
	public int deleteByRoleId(java.lang.Long roleId){
		UserRoleExample example=new UserRoleExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		return mapper.deleteByExample(example);
	}

	public int delete( java.lang.Long userId, java.lang.Long roleId){
		return mapper.deleteByPrimaryKey(userId,roleId);
	}
	/** generate code end**/
}
