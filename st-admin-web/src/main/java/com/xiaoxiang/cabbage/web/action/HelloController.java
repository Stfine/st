package com.xiaoxiang.cabbage.web.action;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/hello",produces = {APPLICATION_JSON_VALUE})
@Api(value="测试",tags="测试")
public class HelloController {

	@RequestMapping(value = "demo1" , method = { RequestMethod.GET})
	@ApiOperation(value="第一个测试",notes="第一个测试")
	public String demo1() {
		return "Hello I'm Demo one ";
	}
	
}
