package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

// @WebFilter("/*")
public class LogFilter implements Filter {
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        System.out.println(request.getRemoteAddr());		
        System.out.println(req.getRequestURI());
        
		chain.doFilter(request, response); // call endpoint 
		// process to be done after endpoint is completed 
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
