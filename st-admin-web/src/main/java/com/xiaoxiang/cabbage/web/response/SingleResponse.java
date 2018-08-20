package com.xiaoxiang.cabbage.web.response;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;


public class SingleResponse<T>  extends AbstractResponse {
	
	public SingleResponse(){
	}
	
	public SingleResponse(MessageSource messageSource,HttpServletRequest request){
		super(messageSource,request);
	}
	
	private T item;

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
}
