package com.xiaoxiang.cabbage.web;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties.WebStatFilter;

@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
initParams= {
		
		 @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")
})
public class DruidStatFilter extends WebStatFilter{

	
}
