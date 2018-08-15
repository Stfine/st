package com.xiaoxiang.cabbage.web.action;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xiaoxiang.cabbage.sys.SysUserConstants;
import com.xiaoxiang.cabbate.service.sys.sccurity.SecurityMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/hello",produces = {APPLICATION_JSON_VALUE})
@Api(value="测试",tags="测试")
public class HelloController {

	@RequestMapping(value = "demo1" , method = { RequestMethod.GET})
	@RequiresPermissions("sys:hello:demo1")
	@SecurityMapping(name="demo1",permGroup="测试",userType=SysUserConstants.USER_TYPE_1)
	@ApiOperation(value="第一个测试",notes="第一个测试")
	public String demo1() {
		return "Hello I'm Demo one ";
	}
	
	@RequestMapping("/demo2")
	@RequiresPermissions("sys:demo:demo2")
	@SecurityMapping(name="demo2",permGroup="测试",userType=SysUserConstants.USER_TYPE_1)
	@ApiOperation(value="第二个测试",notes="第二个测试")
	public String demo2() {
		return "Hello I'm Demo Two";
	}
	
}
