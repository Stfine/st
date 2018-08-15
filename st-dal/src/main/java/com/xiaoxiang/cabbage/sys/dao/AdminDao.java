package com.xiaoxiang.cabbage.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.xiaoxiang.cabbage.sys.mapper.AdminMapper;
import com.xiaoxiang.cabbage.sys.model.Admin;
import com.xiaoxiang.cabbage.sys.bo.AdminBO;
import com.xiaoxiang.cabbage.sys.model.AdminExample;

@Repository
public class AdminDao {

	@Autowired
	private AdminMapper mapper;


   /** generate code begin**/
	public List<AdminBO> findAll(){
		AdminExample example=new AdminExample();
		return mapper.selectByExample(example);
	}
	List<AdminBO> findAll(Iterable<java.lang.Long> ids){
		AdminExample example=new AdminExample();
		example.createCriteria().andUidIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}
	
	public long count(){
		AdminExample example=new AdminExample();
		return mapper.countByExample(example);
	}

	public List<Admin> save(Iterable<Admin> entities){
		List<Admin> list=new ArrayList<Admin>();
		for (Admin Admin : entities) {
			list.add(save(Admin));
		}
		return list;
	}
	
	public Admin save(Admin record){
		if(!exists(record.getUid())){
			mapper.insertSelective(record);
		}else{
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}
	

	public void update(Admin record) {
		mapper.updateByPrimaryKeySelective(record);
	}
	
	public AdminBO findOne(java.lang.Long id){
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id){
		if(id == null){
			return false;
		}
		AdminExample example=new AdminExample();
		example.createCriteria().andUidEqualTo(id);
		return mapper.countByExample(example) > 0;
	}
	
	 public void delete(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }
	 
	 public void remove(java.lang.Long id){
		 mapper.deleteByPrimaryKey(id);
	 }

	public void delete(Admin entity){
		 mapper.deleteByPrimaryKey(entity.getUid());
	}

	public void delete(Iterable<Admin> entities){
		List<java.lang.Long> ids=Lists.newArrayList();
		for (Admin  entity: entities) {
			ids.add(entity.getUid());
		}
		deleteByIds(ids);
	}
	
	public void deleteByIds(Iterable<java.lang.Long> ids){
		AdminExample example=new AdminExample();
		example.createCriteria().andUidIn(Lists.newArrayList(ids));
		 mapper.deleteByExample(example);
	}

	public void deleteAll(){
		AdminExample example=new AdminExample();
		mapper.deleteByExample(example);
	}
	/** generate code end**/
}
