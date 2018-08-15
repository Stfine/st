package com.xiaoxiang.cabbate.service.sys.utils;

import java.lang.annotation.Annotation;
import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;

import com.google.common.collect.Sets;


public class StClassUrils {

	
	public static Set<Class<?>> getClasses(String pack,Class<? extends Annotation> annotation) {
		
		Set<Class<?>> resp = Sets.newHashSet();
		
		ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(true);
		
		Set<BeanDefinition> beanDefinitions =  provider.findCandidateComponents(pack);
		
		for (BeanDefinition beanDefinition : beanDefinitions) {
			
			try {
				resp.add(Thread.currentThread().getContextClassLoader().loadClass(beanDefinition.getBeanClassName()));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return resp;
	}
}
