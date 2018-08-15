package com.xiaoxiang.cabbage.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.xiaoxiang.cabbage.sys.mapper.RoleMapper;
import com.xiaoxiang.cabbage.sys.model.Role;
import com.xiaoxiang.cabbage.sys.bo.RoleBO;
import com.xiaoxiang.cabbage.sys.model.RoleExample;

@Repository
public class RoleDao {

	@Autowired
	private RoleMapper mapper;


   /** generate code begin**/
	public List<RoleBO> findAll(){
		RoleExample example=new RoleExample();
		return mapper.selectByExample(example);
	}
	List<RoleBO> findAll(Iterable<java.lang.Long> ids){
		RoleExample example=new RoleExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}
	
	public long count(){
		RoleExample example=new RoleExample();
		return mapper.countByExample(example);
	}

	public List<Role> save(Iterable<Role> entities){
		List<Role> list=new ArrayList<Role>();
		for (Role Role : entities) {
			list.add(save(Role));
		}
		return list;
	}
	
	public Role save(Role record){
		if(record.getId() == null){
			mapper.insertSelective(record);
		}else{
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}
	

	public void update(Role record) {
		mapper.updateByPrimaryKeySelective(record);
	}
	
	public RoleBO findOne(java.lang.Long id){
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id){
		if(id == null){
			return false;
		}
		RoleExample example=new RoleExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}
	
	 public void delete(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }
	 
	 public void remove(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }

	public void delete(Role entity){
		 mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Role> entities){
		List<java.lang.Long> ids=Lists.newArrayList();
		for (Role  entity: entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}
	
	public void deleteByIds(Iterable<java.lang.Long> ids){
		RoleExample example=new RoleExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		 mapper.deleteByExample(example);
	}

	public void deleteAll(){
		RoleExample example=new RoleExample();
		mapper.deleteByExample(example);
	}
	/** generate code end**/
}
