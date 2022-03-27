package com.backend.inctathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.backend.inctathon.model")
@EnableJpaRepositories(basePackages = "com.backend.inctathon.repository")
public class InctathonApplication {

	public static void main(String[] args) {
		SpringApplication.run(InctathonApplication.class, args); 
	}

}
//@SpringBootApplication
//public class InctathonApplication extends SpringBootServletInitializer {
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(InctathonApplication.class);
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(InctathonApplication.class, args);
//    }
//}
// 