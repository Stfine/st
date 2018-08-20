package com.xiaoxiang.cabbage.web.action;

import java.awt.im.spi.InputMethod;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xiaoxiang.cabbage.sys.SysUserConstants;
import com.xiaoxiang.cabbage.sys.bo.PermissionBO;
import com.xiaoxiang.cabbage.sys.bo.UserAccountBO;
import com.xiaoxiang.cabbage.web.bo.ApiAdminAccessTokenBO;
import com.xiaoxiang.cabbage.web.bo.ApiPermissionBO;
import com.xiaoxiang.cabbage.web.response.Responses;
import com.xiaoxiang.cabbage.web.response.SingleResponse;
import com.xiaoxiang.cabbage.web.utils.MapperUtils;
import com.xiaoxiang.cabbate.service.sys.PermissionService;

import io.swagger.annotations.ApiOperation;

@Controller
@RestController
public class UserController {

	@Autowired
	private MessageSource messagesources;
	
	@Autowired
	private PermissionService permissionService;
	
	private Mapper mapper;
	
	@RequestMapping(value = "/login",method = { RequestMethod.POST,RequestMethod.GET})
	@ApiOperation(value = "用户登陆",notes="用户登陆操作")
	public @ResponseBody ResponseEntity<SingleResponse<ApiAdminAccessTokenBO>> login(HttpServletRequest request,HttpServletResponse response) {
		
		SingleResponse<ApiAdminAccessTokenBO> resp  = 
				new SingleResponse<ApiAdminAccessTokenBO>(messagesources, request);
		
		HttpSession sesion = request.getSession();
		
		Subject subject = SecurityUtils.getSubject();
		
		if(subject.isAuthenticated()) {
			
			ApiAdminAccessTokenBO item = new ApiAdminAccessTokenBO();
			item.setAccessToken(sesion.getId());
			
			UserAccountBO account = (UserAccountBO) subject.getPrincipal();
			
			List<PermissionBO> list = 
					permissionService.findByUid(account.getUid(),SysUserConstants.USER_TYPE_1);
			
			if(!list.isEmpty()) {
				item.setPermissions(MapperUtils.map(mapper, list, ApiPermissionBO.class));
			}
			
			return Responses.ok(resp);
		}
		
		return null;
	}
}
