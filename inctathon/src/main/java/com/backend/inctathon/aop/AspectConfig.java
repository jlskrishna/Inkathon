package com.backend.inctathon.aop;

import java.lang.reflect.Method;
import java.net.http.HttpResponse.ResponseInfo;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.weaver.reflect.JoinPointMatchImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import com.backend.inctathon.controller.StudentController;
import com.backend.inctathon.exception.ResourceNotFoundException;
import com.backend.inctathon.model.ReportEntity;
import com.backend.inctathon.model.Student;

@Aspect
@Configuration
public class AspectConfig {
	int get=0;
	int post=0;
	/*
	 * Logging
	 * Exception Handling
	 * TimeTaken
	 */
	
	private Logger log=LoggerFactory.getLogger(AspectConfig.class);
	@Before(value = "execution(* com.backend.inctathon.controller.*.*(..))")
	public void logStatementBefore(JoinPoint joinPoint) {
		//System.out.println("gaurav before");
		log.info("Executing {}",joinPoint);
	}
	
	@After(value = "execution(* com.backend.inctathon.controller.*.*(..))")
	public void logStatementAfter(JoinPoint joinPoint) {
		//System.out.println("gaurav after");
		log.info("Complete exceution of {}",joinPoint);
	}
	
	
	@Around(value = "execution(* com.backend.inctathon.*.*(..))")
	public Object taskHandler(ProceedingJoinPoint joinPoint) throws Throwable {
		
		try {
			Object obj=joinPoint.proceed();
			//System.out.println("gaurav");
			return obj;
		}
		catch(ResourceNotFoundException e) {
			log.info(" TaskException StatusCode {}","failed");
			log.info("TaskException Message {}",e.getMessage());
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "bad request");
		}
	}

	@Around(value = "execution(* com.backend.inctathon.controller.*.*(..))")
	public Object timeTracker(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long stratTime=System.currentTimeMillis();
		 Class clazz = joinPoint.getTarget().getClass();
	        Logger logger = LoggerFactory.getLogger(clazz);
	        String url = getRequestUrl(joinPoint, clazz);
	        System.out.println("url of the request is"+ url);
	        String payload = getPayload(joinPoint);
	        
		try {
			System.out.println("payload of the request is ");
			Object obj=joinPoint.proceed();
			log.info("json", obj);
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
			System.out.println(auth.getDetails());
			System.out.println(auth.getName());
			System.out.println(auth.getPrincipal().toString());
			long timeTaken=System.currentTimeMillis()-stratTime;
			//log.info("Time taken by {} is {}",joinPoint,timeTaken);
			System.out.println("time taken by api "+timeTaken+" milliSeconds");
			LocalDate localDate = LocalDate.now();
			System.out.println("this api is accessed on time "+LocalTime.now());
			System.out.println("this api is accessed on " +localDate);
			MethodSignature methodSignature = (MethodSignature)(joinPoint.getSignature());
			Method method = methodSignature.getMethod();
			System.out.println("annotation name is "+ method.getAnnotations());
			System.out.println("****Argumets*******");
			System.out.println("method called by api is "+method.getName());
			System.out.println(method.getReturnType());
			System.out.println("number of formal parameters "+method.getParameterCount()); 
			//System.out.println("the return type for the method this object represents "+method.getReturnType());
			String methodName=methodSignature.getMethod().getName();
			if(methodName.equals("getAllStudents")||methodName.equals("listStudents")||methodName.equals("editStudentForm")||methodName.equals("deleteStudent")) {
				get++;
			}
			else if(methodName.equals("saveStudent")||methodName.equals("updateStudent")) {
				post++;
			}
			ReportEntity reportEntity = new ReportEntity();
			reportEntity.setId(get);
	        System.out.println("total number of GET api called is " +reportEntity.getId());
	        System.out.println("total number of POST api called is " +post);
	        Object[] args = joinPoint.getArgs();
	       System.out.println("....................******************..........................................");
	       
	        
	        
			return obj;
		}
		catch(ResourceNotFoundException e) {
			log.info(" TaskException StatusCode {}","failed");
			log.info("TaskException Message {}",e.getMessage());
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "bad request");
		}
	}
	//gaurav
	
//	@Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
//    public void postAction() {
//    }
//
//    @Around(value = "execution(* org.springframework.web.bind.annotation.PostMapping.*.*(..))")
//	//@Around(value = "execution(* com.backend.inctathon.controller.*.*(..))")
//	
//	public void logAction(JoinPoint joinPoint) {
//        Class clazz = joinPoint.getTarget().getClass();
//        Logger logger = LoggerFactory.getLogger(clazz);
//
//       // String url = getRequestUrl(joinPoint, clazz);
//        String payload = getPayload(joinPoint);
//        System.out.println(payload);
//        logger.info("POST " + payload + " Payload " + payload);
//    }
	private String getRequestUrl(JoinPoint joinPoint, Class clazz) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        PostMapping methodPostMapping = method.getAnnotation(PostMapping.class);
        RequestMapping requestMapping = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
       // return getPostUrl(requestMapping, methodPostMapping);
        System.out.println("method is  "+method.getAnnotation(PostMapping.class));

        
        return "kuch bhi";
    }

    private String getPayload(JoinPoint joinPoint) {
        CodeSignature signature = (CodeSignature) joinPoint.getSignature();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            String parameterName = signature.getParameterNames()[i];
            System.out.print("parameter name is "+parameterName);
            builder.append(parameterName);
            System.out.print(": ");
            builder.append(": ");
            System.out.print("arguments are  "+joinPoint.getArgs()[i].toString());
            builder.append(joinPoint.getArgs()[i].toString());
            System.out.print(", ");
            builder.append(", ");
            System.out.println();
        }
        return builder.toString();
    }
//
    private String getPostUrl(RequestMapping requestMapping, PostMapping postMapping) {
        String baseUrl = getUrl(requestMapping.value());
        String endpoint = getUrl(postMapping.value());

        return baseUrl + endpoint;
    }

    private String getUrl(String[] urls) {
        if (urls.length == 0) return "";
        else return urls[0];
    }
//	//gaurav
//	
}
