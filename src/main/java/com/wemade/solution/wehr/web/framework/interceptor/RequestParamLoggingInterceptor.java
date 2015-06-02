package com.wemade.solution.wehr.web.framework.interceptor;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestParamLoggingInterceptor extends HandlerInterceptorAdapter {

	private static Logger logger = Logger.getLogger(RequestParamLoggingInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		
		if(logger.isDebugEnabled()){
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			String key = null;
			String[] values = null;
			
			pw.println();
			pw.println("==========================================================================================================================================================================================================================");
			pw.print("Request URL    = ");
			pw.println(request.getRequestURL().toString());
			
			pw.print("Character Encoding    = ");
			pw.println(request.getCharacterEncoding());
			
			pw.print("Request Method = ");
			pw.println(request.getMethod());
			pw.print("Request ACCEPT = ");
			pw.println(request.getHeader("accept"));
			
			@SuppressWarnings("rawtypes")
			Enumeration e = request.getParameterNames();
			if(e != null){
				while(e.hasMoreElements()){
					key = (String) e.nextElement();
					values = request.getParameterValues(key);
					
					if(values == null){
						pw.print(key);
						pw.println("= {null}");
					}else{
						if(values.length == 0){
							pw.print(key);
							pw.println("= [null]");
						}else if(values.length == 1){
							pw.print(key);
							pw.print("=");
							pw.println(values[0]);
						}else{
							pw.print(key);
							pw.print("=[");
							for(int i = 0 ; i < values.length ; i++){
								pw.print(values[i]);
								if(i != values.length-1){
									pw.print(", ");
								}
							}
							pw.println("]");
						}
					}
				}
			}
			if (!(handler instanceof HandlerMethod)) {
				pw.print("Current Request Handler : ");
				pw.println(handler.getClass().getCanonicalName());
			}else{
				HandlerMethod method = (HandlerMethod) handler;
				pw.print("Current Request Handler : ");
				pw.print(method.getBeanType().getCanonicalName());
				pw.print(".");
				pw.print(method.getMethod().getName());
				pw.println("()");
			}
			pw.println("==========================================================================================================================================================================================================================");
			logger.debug(sw.toString()); 
			pw.close();
		}
		return true;
	}

}