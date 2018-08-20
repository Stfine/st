package com.xiaoxiang.cabbage.web.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;


public class KickoutSessionFilter extends AccessControlFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		Subject subject = getSubject(request, response);
		
		if(!subject.isAuthenticated() && !subject.isRemembered()) {
			return true;
		}
		
		Session session = subject.getSession();
		
//		 Object kickoutUrl=session.getAttribute(FormAuthenticationFilter.KICKOUT_URL_SESSION_ATTRIBUTE_KEY);
		 
		return false;
	}

}
