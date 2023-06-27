package com.example.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Slf4j     // log 추가
@Aspect    // 이 클래스가 관점(Aspect)임을 드러내는 어노테이션
@Component // Bean 객체로 등록
public class LoggingAspect {
    // 컨트롤러 클래스
    // @Before: Advice, 실제로 실행될 코드를 나타냄
    // @Before.value: Pointcut Designator, 어느 JoinPoint에서
    // 실행될 것인지

//    // this: 클래스 instance 지정
//    @Before("this(com.example.aop.controller.AopController)")
    // within: 클래스 또는 패키지 지정
//    @Before("within(com.example.aop.controller.AopController)")  // 또는
//    @Before("within(com.example.aop.controller..*)")
    // @annotation: 어노테이션 지정
    @After("@annotation(com.example.aop.aspect.LogArguments)")
    // JoinPoint: 이 Advice 가 실행된 JoinPoint (addUser)
    public void logParameters(JoinPoint joinPoint) {
        // Signature: JoinPoint 의 정보를 담은 객체
        Signature signature
                = joinPoint.getSignature();
        // 메소드 이름 로그
        log.info(signature.getName());
        // 메소드 인자들 확인
        Object[] arguments = joinPoint.getArgs();
        // 인자가 없을 때
        if (arguments.length == 0) {
            log.info("no args");
        }
        for (Object argument: arguments) {
            log.info("argument: [{}]", argument);
        }
    }

    // @LogExecutionTime 어노테이션이 붙은 메소드의
    // 실행되는데 걸리는 시간을 기록하고 싶다.
    @Around("@annotation(com.example.aop.aspect.LogExecutionTime)")
    public Object logExecutionTime(
            // Advice 내에서 대상 JoinPoint 가 실행되도록
            // 요구할 수 있다.
            ProceedingJoinPoint joinPoint
    ) throws Throwable {
        log.info("start log execution time");
        long startTime = System.currentTimeMillis();

        // joinPoint.proceed(): JoinPoint에 해당하는 메소드를
        // 진행해주세요
        Object proceed = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        // 실제로 추가하고 싶은 기능
        log.info("{} executed in: {}ms",
                joinPoint.getSignature(), endTime - startTime);

        return proceed;
    }

}










