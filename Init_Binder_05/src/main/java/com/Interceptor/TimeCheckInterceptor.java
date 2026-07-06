package com.Interceptor;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TimeCheckInterceptor implements HandlerInterceptor {
	
	public boolean preHandle(HttpServletRequest req,HttpServletResponse res,Object handler) throws ServletException, IOException {
	System.out.println("TimeCheckInterceptor");
	LocalDateTime ldt = LocalDateTime.now();
	int hour = ldt.getHour();
	if(hour>9 || hour>22) {
		RequestDispatcher rd  = req.getRequestDispatcher("/timeout.jsp");
		rd.forward(req, res);
		return false;
	}
	return true;
	
	}

}
