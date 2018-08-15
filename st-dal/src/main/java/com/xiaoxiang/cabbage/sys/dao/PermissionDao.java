package com.xiaoxiang.cabbage.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.dozer.fieldmap.ExcludeFieldMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.xiaoxiang.cabbage.sys.mapper.PermissionMapper;
import com.xiaoxiang.cabbage.sys.model.Permission;
import com.xiaoxiang.cabbage.sys.bo.PermissionBO;
import com.xiaoxiang.cabbage.sys.model.PermissionExample;

@Repository
public class PermissionDao {

	@Autowired
	private PermissionMapper mapper;

	public List<PermissionBO> findNotInValues(List<String> listVlues,int userType) {
		PermissionExample example=new PermissionExample();
		example.createCriteria()
		.andUserTypeEqualTo(userType)
		.andValueNotIn(listVlues);
		return mapper.selectByExample(example);
	}
	
	public void deleteNotInValues(List<String> list,int userType) {
		PermissionExample example=new PermissionExample();
		example.createCriteria()
		.andUserTypeEqualTo(userType)
		.andValueNotIn(list);
		mapper.deleteByExample(example);
	}
	
   /** generate code begin**/
	public List<PermissionBO> findAll(){
		PermissionExample example=new PermissionExample();
		return mapper.selectByExample(example);
	}
	List<PermissionBO> findAll(Iterable<java.lang.Long> ids){
		PermissionExample example=new PermissionExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}
	
	public long count(){
		PermissionExample example=new PermissionExample();
		return mapper.countByExample(example);
	}

	public List<Permission> save(Iterable<Permission> entities){
		List<Permission> list=new ArrayList<Permission>();
		for (Permission Permission : entities) {
			list.add(save(Permission));
		}
		return list;
	}
	
	public Permission save(Permission record){
		if(record.getId() == null){
			mapper.insertSelective(record);
		}else{
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}
	

	public void update(Permission record) {
		mapper.updateByPrimaryKeySelective(record);
	}
	
	public PermissionBO findOne(java.lang.Long id){
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id){
		if(id == null){
			return false;
		}
		PermissionExample example=new PermissionExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}
	
	 public void delete(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }
	 
	 public void remove(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }

	public void delete(Permission entity){
		 mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Permission> entities){
		List<java.lang.Long> ids=Lists.newArrayList();
		for (Permission  entity: entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}
	
	public void deleteByIds(Iterable<java.lang.Long> ids){
		PermissionExample example=new PermissionExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		 mapper.deleteByExample(example);
	}

	public void deleteAll(){
		PermissionExample example=new PermissionExample();
		mapper.deleteByExample(example);
	}
	/** generate code end**/


	
}
