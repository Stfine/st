package com.xiaoxiang.cabbage.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.xiaoxiang.cabbage.sys.mapper.UserAccountMapper;
import com.xiaoxiang.cabbage.sys.model.UserAccount;
import com.xiaoxiang.cabbage.sys.bo.UserAccountBO;
import com.xiaoxiang.cabbage.sys.model.UserAccountExample;

@Repository
public class UserAccountDao {

	@Autowired
	private UserAccountMapper mapper;

	public UserAccountBO findByLoginName(String loginName) {
		UserAccountExample example=new UserAccountExample();
		example.createCriteria().andLoginNameEqualTo(loginName);
		List<UserAccountBO> list = mapper.selectByExample(example);
		return list.isEmpty()?null:list.get(0);
	}

   /** generate code begin**/
	public List<UserAccountBO> findAll(){
		UserAccountExample example=new UserAccountExample();
		return mapper.selectByExample(example);
	}
	List<UserAccountBO> findAll(Iterable<java.lang.Long> ids){
		UserAccountExample example=new UserAccountExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}
	
	public long count(){
		UserAccountExample example=new UserAccountExample();
		return mapper.countByExample(example);
	}

	public List<UserAccount> save(Iterable<UserAccount> entities){
		List<UserAccount> list=new ArrayList<UserAccount>();
		for (UserAccount UserAccount : entities) {
			list.add(save(UserAccount));
		}
		return list;
	}
	
	public UserAccount save(UserAccount record){
		if(record.getId() == null){
			mapper.insertSelective(record);
		}else{
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}
	

	public void update(UserAccount record) {
		mapper.updateByPrimaryKeySelective(record);
	}
	
	public UserAccountBO findOne(java.lang.Long id){
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id){
		if(id == null){
			return false;
		}
		UserAccountExample example=new UserAccountExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}
	
	 public void delete(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }
	 
	 public void remove(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }

	public void delete(UserAccount entity){
		 mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<UserAccount> entities){
		List<java.lang.Long> ids=Lists.newArrayList();
		for (UserAccount  entity: entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}
	
	public void deleteByIds(Iterable<java.lang.Long> ids){
		UserAccountExample example=new UserAccountExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		 mapper.deleteByExample(example);
	}

	public void deleteAll(){
		UserAccountExample example=new UserAccountExample();
		mapper.deleteByExample(example);
	}
	/** generate code end**/
	
}
