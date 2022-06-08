package SOF3021.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import SOF3021.intorceptor.LoginIntorceptor;

@Configuration
public class intorceptorConfiguration implements WebMvcConfigurer {
	
	@Autowired
	private LoginIntorceptor loginIntorceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// đăng ký Interceptors với spring
		List<String> PathPatterns = new ArrayList<String>();
		PathPatterns.add("/admin/accounts/create");
		PathPatterns.add("/admin/category/create");
		PathPatterns.add("/admin/order/create");
		registry.addInterceptor(loginIntorceptor)
		.addPathPatterns(PathPatterns);
	}
	
	
	
}
