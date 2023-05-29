package com.minglemingle.chat2mingle.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	Logger log = LogManager.getLogger("case3");

	@Before(value = "@annotation(com.minglemingle.chat2mingle.aspect.annotation.DebugLog)")
	public void before(JoinPoint joinPoint) {
		MethodSignature ms = (MethodSignature) joinPoint.getSignature();
		Method method = ms.getMethod();
		log.debug("호출 메서드: " + method.getName());

		Arrays.stream(joinPoint.getArgs()).forEach(o -> log.debug("매개변수: " + o));

	}
	@AfterReturning(value = "@annotation(com.minglemingle.chat2mingle.aspect.annotation.DebugLog)",
					returning="retVal")
	public void after(Object retVal) {
		log.debug("리턴: " + retVal);
	}
}
