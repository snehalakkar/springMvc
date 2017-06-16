package com.bridgeLabz.springMvcDemo.intercepter;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class WeekDayBasedAccessedIntercepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Calendar cal = Calendar.getInstance();
		int day = cal.get(cal.DAY_OF_WEEK);
		if (day == 1) //day==1 means sunday ,day==2 means monday and hence onwards
		{
			response.getWriter()
					.write("The website is closed on sunday please try to access it on any other weekdays....");
			return false;
		}
		return true;
	}

}
