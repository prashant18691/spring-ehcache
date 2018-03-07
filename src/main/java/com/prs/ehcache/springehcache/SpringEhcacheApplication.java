package com.prs.ehcache.springehcache;

import com.prs.ehcache.springehcache.config.AppConfig;
import com.prs.ehcache.springehcache.dao.MovieDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringEhcacheApplication {
	private static final Logger log = LoggerFactory.getLogger(SpringEhcacheApplication.class);
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MovieDao obj = (MovieDao) context.getBean("movieDao");

		log.debug("Result : {}", obj.findByDirector("dummy"));
		log.debug("Result : {}", obj.findByDirector("dummy"));
		log.debug("Result : {}", obj.findByDirector("dummy"));
		((ConfigurableApplicationContext)context).close();
	}
}
