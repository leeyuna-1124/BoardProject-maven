package com.example.configuration.servlet.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BaseHandlerInterceptor implements HandlerInterceptor {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
    @Override	
    //컨트롤러로 보내지기 전에 수행되는 메소드
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		logger.info("preHandle requestURI : {}", request.getRequestURI());
		return true;
	}
    
    @Override
    //컨트롤러로 보내진 후에 수행되는 메소드
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("postHandle requestURI : {}", request.getRequestURI());
		
	}
}
