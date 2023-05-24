package com.minglemingle.chat2mingle.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
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
		log.debug(method.getName() + "메서드 호출");

		Arrays.stream(joinPoint.getArgs()).forEach(o -> {
			log.debug("매개변수 value: " + o);
		});

	}
}
