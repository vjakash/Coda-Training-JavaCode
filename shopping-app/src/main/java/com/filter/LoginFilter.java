package com.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		List<String> list=new ArrayList<String>();
		list.add("home");
		list.add("account");
		list.add("cart");
		list.add("category");
		list.add("deliveryAddress");
		list.add("payment");
		
		HttpServletRequest req=(HttpServletRequest)request;
		
		System.out.println(req.getRequestURI());
		HttpSession session=req.getSession();
		
		if((session.isNew() || session.getAttribute("user")==null) && req.getRequestURI().split("/").length>0 && list.contains(req.getRequestURI().split("/")[1]) ) {
//			RequestDispatcher rd=request.getRequestDispatcher("/");
//			rd.forward(request, response);
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("/");
		}else {			
			chain.doFilter(request, response);
		}
//		chain.doFilter(request, response);
	}

}
