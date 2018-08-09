package com.xiaoxiang.cabbage.web.action;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xiaoxiang.cabbage.sys.bo.PermissionBO;
import com.xiaoxiang.cabbate.service.sys.PermissionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "permission" , produces = {APPLICATION_JSON_VALUE})
@Api(value=" 权限 api",tags="权限 api")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping(value = "list", method= {RequestMethod.POST})
	@ApiOperation(value="查询全部",notes="查询全部")
	public List<PermissionBO> findAll(){
		return permissionService.findAll();
	}
}
