package com.didiElectrician.util;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

public class FilterUtils {

	private static ApplicationContext ctx = null;
	
	public static Object getBeans(HttpServletRequest req, String name) {
		if (ctx == null) {
			ctx = WebApplicationContextUtils
					.getRequiredWebApplicationContext(req.getSession()
							.getServletContext());
		}
		return ctx.getBean(name);
	}
}
