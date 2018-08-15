package com.xiaoxiang.cabbage.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.xiaoxiang.cabbage.sys.mapper.UserMapper;
import com.xiaoxiang.cabbage.sys.model.User;
import com.xiaoxiang.cabbage.sys.bo.UserBO;
import com.xiaoxiang.cabbage.sys.model.UserExample;

@Repository
public class UserDao {

	@Autowired
	private UserMapper mapper;


   /** generate code begin**/
	public List<UserBO> findAll(){
		UserExample example=new UserExample();
		return mapper.selectByExample(example);
	}
	List<UserBO> findAll(Iterable<java.lang.Long> ids){
		UserExample example=new UserExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}
	
	public long count(){
		UserExample example=new UserExample();
		return mapper.countByExample(example);
	}

	public List<User> save(Iterable<User> entities){
		List<User> list=new ArrayList<User>();
		for (User User : entities) {
			list.add(save(User));
		}
		return list;
	}
	
	public User save(User record){
		if(record.getId() == null){
			mapper.insertSelective(record);
		}else{
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}
	

	public void update(User record) {
		mapper.updateByPrimaryKeySelective(record);
	}
	
	public UserBO findOne(java.lang.Long id){
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id){
		if(id == null){
			return false;
		}
		UserExample example=new UserExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}
	
	 public void delete(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }
	 
	 public void remove(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }

	public void delete(User entity){
		 mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<User> entities){
		List<java.lang.Long> ids=Lists.newArrayList();
		for (User  entity: entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}
	
	public void deleteByIds(Iterable<java.lang.Long> ids){
		UserExample example=new UserExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		 mapper.deleteByExample(example);
	}

	public void deleteAll(){
		UserExample example=new UserExample();
		mapper.deleteByExample(example);
	}
	/** generate code end**/
}
