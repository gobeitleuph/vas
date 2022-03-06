package de.leuphana.shop.aop;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class MethodLogger implements MethodBeforeAdvice, AfterReturningAdvice {
	private Logger logger = LogManager.getLogger(this.getClass());
	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		logger.info("enter " + target.getClass().getName() + "." + method.getName());
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		logger.info("exit " + target.getClass().getName() + "." + method.getName());
	}
}