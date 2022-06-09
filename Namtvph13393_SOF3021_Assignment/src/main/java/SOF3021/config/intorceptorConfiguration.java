package SOF3021.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import SOF3021.intorceptor.AdminInerceptor;
import SOF3021.intorceptor.AuthenticateInterceptor;
import SOF3021.intorceptor.LoginIntorceptor;

@Configuration
public class intorceptorConfiguration implements WebMvcConfigurer {

	@Autowired
	private AuthenticateInterceptor authenticateInterceptor;

	@Autowired
	private AdminInerceptor adminInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authenticateInterceptor)
		.addPathPatterns("/admin/**");

		registry.addInterceptor(adminInterceptor)
		.addPathPatterns("/admin/**");
	}

}
