package com.tt.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	private ArrayList<String> allowedUrlList;
	
	
	public void init(FilterConfig config) throws ServletException {
		
		String urls = config.getInitParameter("avoid-urls");
		StringTokenizer token = new StringTokenizer(urls, ",");
		
		System.out.println(urls);
		
		this.allowedUrlList=new ArrayList<String>();
		
		while(token.hasMoreElements())
		{
			this.allowedUrlList.add(token.nextToken());
		}
		
		System.out.println("At 0 location is " + this.allowedUrlList.get(0));
	}
		
		
		public void doFilter(ServletRequest req, ServletResponse res,
				FilterChain chain) throws IOException, ServletException {
			
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) res;
			
			
			String url = request.getServletPath();
			boolean allowedRequest = false;
			
			if(this.allowedUrlList.contains(url)) {
				allowedRequest = true;
			}
			
			System.out.println("The value of allowed Requets is " + allowedRequest + " " + url );
			
			if (!allowedRequest) {
				HttpSession session = request.getSession(true);
				/*if(session!=null && url.equals("/logout"))
				{	System.out.println("Inside logout now");
					session.invalidate();
					session=null;
				}*/
				System.out.println(session);
				if (session.getAttribute("isSession")==null) {
					System.out.println("I am here");
					response.sendRedirect(""); 
					return;
					//request.getRequestDispatcher("/WEB-INF/views/LoginPage.jsp")
                    //.forward(req, res);
				}
				else {
					
					chain.doFilter(request, response);
				}
				
				
			}
			
			chain.doFilter(request, response);
					
		}
	
	public void destroy() {

	}
	
	
	
	
	
	
}
