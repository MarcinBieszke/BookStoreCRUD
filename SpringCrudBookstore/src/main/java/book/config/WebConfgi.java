package book.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import book.intereceptor.Intereceptor;

@Configuration
public class WebConfgi extends WebMvcConfigurerAdapter {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(new Intereceptor()).addPathPatterns("/add");
	}

}
