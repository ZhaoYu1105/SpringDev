package web.framework.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import web.framework.java.base.BaseService;


@SpringBootApplication
@ServletComponentScan
public class BootApplication {

    public static void main(String[] args) {
//        SpringApplication.run(BootApplication.class, args);
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "dubbo-consumer.xml" });
        context.start();
        
        BaseService baseService = (BaseService) context.getBean("baseService");
        String sss = baseService.demo("ttt");
        System.out.println(sss);
    }
}
