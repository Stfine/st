package com.xiaoxiang.cabbage.web.utils;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;

/**
 * 工具映射工具类
 * @author zhanggaoxiang
 *
 */
public class MapperUtils {

	public static <T,M> ArrayList<M> map(Mapper mapper,List<T> source, Class<M> target){
		
		if(source.isEmpty()) {
			return null;
		}
		
		ArrayList<M> resp = new ArrayList<M>();
		
		for (T t : source) {
			if(null != t) {
				resp.add(mapper.map(t, target));
			}
		}
		return resp;
	}
	
}
