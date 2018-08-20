package com.xiaoxiang.cabbage.web.security;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.sinco.common.utils.Encodes;
import com.xiaoxiang.cabbage.sys.SysUserConstants;
import com.xiaoxiang.cabbage.sys.bo.PermissionBO;
import com.xiaoxiang.cabbage.sys.bo.UserAccountBO;
import com.xiaoxiang.cabbage.sys.model.User;
import com.xiaoxiang.cabbate.service.sys.PermissionService;
import com.xiaoxiang.cabbate.service.sys.UserAccountService;
import com.xiaoxiang.cabbate.service.sys.UserService;
import com.xiaoxiang.cabbate.service.sys.exception.UnKnowAccountException;


public class AdminRealm extends AuthorizingRealm {
	
	@Autowired
	private UserAccountService userAccountService;
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		AdminPrincipal adminPrincipal = (AdminPrincipal) principals.getPrimaryPrincipal();
		
//		UserAccountBO account = (UserAccountBO) principals.getPrimaryPrincipal();
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		List<PermissionBO> list = 
				permissionService.findByUid(adminPrincipal.getId(),SysUserConstants.USER_TYPE_1);
		
		if(!list.isEmpty()) {
			for (PermissionBO p : list) {
				if(StringUtils.isNotBlank(p.getValue())) {
					info.addStringPermission(p.getValue());
				}
			}
		}
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		
		if(StringUtils.isEmpty(token.getUsername())) {
			throw new UnKnowAccountException("用户名不能为空");
		}
		
		UserAccountBO account = userAccountService.findByLoginName(token.getUsername());
		if(null == account) {
			throw new UnKnowAccountException("用户名不存在"); 
		}
		
		User user = userService.findOne(account.getUid());
		if(null == user) {
			throw new UnKnowAccountException("用户名不存在"); 
		}
		byte[] salt = Encodes.decodeHex(account.getPassword().substring(0,16));
		return new SimpleAuthenticationInfo(new AdminPrincipal(user, account.getLoginName(), null),
				account.getPassword().substring(16), ByteSource.Util.bytes(salt), getName());
	}

}
