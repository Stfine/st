package com.xiaoxiang.cabbage.web.bo;

import java.util.List;

public class ApiAdminAccessTokenBO {

	private String accessToken;
	
	private List<ApiPermissionBO> permissions;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public List<ApiPermissionBO> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<ApiPermissionBO> permissions) {
		this.permissions = permissions;
	}
	
}
