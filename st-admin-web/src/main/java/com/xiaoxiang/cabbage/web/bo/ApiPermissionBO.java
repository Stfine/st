package com.xiaoxiang.cabbage.web.bo;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class ApiPermissionBO {

	@ApiModelProperty("编号")
	private Long id;

	@ApiModelProperty("名称")
	private String name;

	@ApiModelProperty("value值")
	private String value;

	@ApiModelProperty("组名称")
	private String groupName;

	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
