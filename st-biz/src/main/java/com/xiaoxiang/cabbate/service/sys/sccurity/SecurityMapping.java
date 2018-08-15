package com.xiaoxiang.cabbate.service.sys.sccurity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SecurityMapping {

	/**
	 * 权限名称
	 * @return
	 */
	String name();
	
	/**
	 * 分组名称
	 * @return
	 */
	String permGroup();
	/**
	 * 用户类习惯
	 * @return
	 */
	int userType();
	
}
