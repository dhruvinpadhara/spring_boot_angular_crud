package com.db;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.db.model.Employee;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);
	
//	@Before("execution(public * com.db.conttroller.FileController.emp())")
	public void logbefore(){
//		LOGGER.info("employee show can be called");
	}
	
//	@After("execution(public * com.db.conttroller.FileController.emp())")
	public void logafter(){
//		LOGGER.info("employee show can be called after aspext");
		System.out.println("employee show can be called after aspext");
	}
}
