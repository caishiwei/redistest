package com.cai.filter;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Stream;

public class XssFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext servletContext = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		filterChain.doFilter(new XSSServletRequestWrapper((HttpServletRequest) request),response);
	}

	@Override
	public void destroy() {

	}
	class XSSServletRequestWrapper extends HttpServletRequestWrapper{

		public XSSServletRequestWrapper(HttpServletRequest request) {
			super(request);
		}

		@Override
		public String getParameter(String name) {
			return HtmlUtils.htmlEscape(super.getParameter(name));
		}

		@Override
		public String[] getParameterValues(String name) {
			String [] values = super.getParameterValues(name);
			for(int i = 0; i<values.length;i++){
				values[i] = HtmlUtils.htmlEscape(values[i]);
			}
			return values;
		}
	}
}
