package bolao.util.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConexaoFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, java.io.IOException {
	    HttpServletRequest request = (HttpServletRequest) req;
	    HttpServletResponse response = (HttpServletResponse) resp;

	    // This should be added in response to both the preflight and the actual request
	    response.addHeader("Access-Control-Allow-Origin", "*");

	    if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
	        response.addHeader("Access-Control-Allow-Credentials", "true");
	    }

	    chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
