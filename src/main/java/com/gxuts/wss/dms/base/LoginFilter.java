package com.gxuts.wss.dms.base;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest req=(HttpServletRequest) request;
		 HttpServletResponse resp=(HttpServletResponse) response;
		 String url=req.getRequestURI();
//		 if((req.getSession(true).getAttribute("loginUser")!=null)||url.contains("ogin")||url.contains("register")){
			 chain.doFilter(request, response);
//		 }else{
//			 resp.sendRedirect("/drug/user/login");
//		 }
	}

	@Override
	public void destroy() {
	}

}