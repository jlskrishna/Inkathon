//package com.backend.inctathon.aspect;
//
//import java.lang.reflect.Method;
//
//import org.aspectj.lang.JoinPoint;  
//import org.aspectj.lang.annotation.Aspect;  
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.CodeSignature;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.PostMapping;
////@Aspect  
////@Component  
////public class StudentServiceAspect   
////{  
////@Before(value = "execution(*com.backend.inctathon.service.impl.StudentServiceImpl.*(..)) and args(id,firstName,lastName,email)")  
////public void afterAdvice(JoinPoint joinPoint, long id, String firstName, String lastName,String email) {  
////System.out.println("After method:" + joinPoint.getSignature());  
////System.out.println("Creating Employee with first name - " + firstName + ", second name - " + lastName + " and email - " + email);  
////}  
////}  
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Component
//@Aspect
//public class StudentServiceAspect  {
//
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
//    public void postAction() {
//    }
//
//    @Before("postAction()")
//    public void logAction(JoinPoint joinPoint) {
//        Class clazz = joinPoint.getTarget().getClass();
//        Logger logger = LoggerFactory.getLogger(clazz);
//
//        String url = getRequestUrl(joinPoint, clazz);
//        String payload = getPayload(joinPoint);
//        logger.info("POST " + url + " Payload " + payload);
//    }
//
//    private String getRequestUrl(JoinPoint joinPoint, Class clazz) {
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        Method method = methodSignature.getMethod();
//        PostMapping methodPostMapping = method.getAnnotation(PostMapping.class);
//        RequestMapping requestMapping = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
//        return getPostUrl(requestMapping, methodPostMapping);
//    }
//
//    private String getPayload(JoinPoint joinPoint) {
//        CodeSignature signature = (CodeSignature) joinPoint.getSignature();
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < joinPoint.getArgs().length; i++) {
//            String parameterName = signature.getParameterNames()[i];
//            builder.append(parameterName);
//            builder.append(": ");
//            builder.append(joinPoint.getArgs()[i].toString());
//            builder.append(", ");
//        }
//        return builder.toString();
//    }
//
//    private String getPostUrl(RequestMapping requestMapping, PostMapping postMapping) {
//        String baseUrl = getUrl(requestMapping.value());
//        String endpoint = getUrl(postMapping.value());
//
//        return baseUrl + endpoint;
//    }
//
//    private String getUrl(String[] urls) {
//        if (urls.length == 0) return "";
//        else return urls[0];
//    }
//}

package com.backend.inctathon.aspect;

import com.backend.inctathon.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class StudentServiceAspect {

    //@Pointcut("execution(* com.example.aop.springaop.controller.*.*(..))")
    //@Pointcut("within(com.example.aop.springaop..*)")
    //@Pointcut("this(com.example.aop.springaop.service.DepartmentService)")
    @Pointcut("@annotation(com.backend.inctathon.annotation.CustomAnnotation)")
    public void loggingPointCut(){}

//    @Before("loggingPointCut()")
//    public void before( JoinPoint joinPoint ){
//        log.info("Before method invoked::"+joinPoint.getSignature());
//    }
    @AfterReturning(value = "execution(* com.backend.inctathon.controller.*.*(..))",
            returning = "student")
    public void after( JoinPoint joinPoint, Student student){
        System.out.println("After method invoked::"+student);
    }
//    @AfterThrowing(value = "execution(* com.example.aop.springaop.controller.*.*(..))",
//            throwing = "e")
//    public void after( JoinPoint joinPoint, Exception e ){
//        log.info("After method invoked::"+e.getMessage());
//    }


//    @Around("loggingPointCut()")
//    public Object around( ProceedingJoinPoint joinPoint ) throws Throwable {
//        log.info("Before method invoked::"+joinPoint.getArgs()[0]);
//        Object object = joinPoint.proceed();
//
//        if(object instanceof Employee){
//            log.info("After method invoked..."+joinPoint.getArgs()[0]);
//        }else if(object instanceof Department){
//            log.info("After method invoked..."+joinPoint.getArgs()[0]);
//        }
//
//        return object;
//    }

}