package com.xiaoxiang.cabbage.sys;


import java.util.List;

import com.google.common.collect.Lists;
import com.sinco.mybatis.generator.GeneratorTable;
import com.sinco.mybatis.generator.MyBatisGeneratorTool2;
import com.sinco.mybatis.generator.config.JdbcConfig;

/**
 * 代码自动产生
 *
 */
public class Generator {

	public static void main(String[] args) {

		//自动产生代码生成改造 by james
		JdbcConfig jdbc = new JdbcConfig(
				"jdbc:postgresql://localhost/test",
				"postgres", "admin123",
				"org.postgresql.Driver");

		String itemPath = "/Users/zhanggaoxiang/workspace/st/st-dal/src/main/java";
		String rootPackage = "com.xiaoxiang.cabbage.sys";

		MyBatisGeneratorTool2 tool = new MyBatisGeneratorTool2(jdbc, itemPath, rootPackage);
		tool.setGeneratorBO(true);
		tool.setGeneratorDao(true);
		tool.setGeneratorMapperJava(true);

		List<GeneratorTable> tableList=Lists.newArrayList(
				new GeneratorTable("public", "sys_permission", "Permission")
		);
				
		tool.generator(tableList);

		System.out.println("恭喜生成完成！！！");
	}

}
