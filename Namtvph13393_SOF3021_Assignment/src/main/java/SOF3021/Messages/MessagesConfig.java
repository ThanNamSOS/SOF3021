package SOF3021.Messages;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessagesConfig {
	//@Primary
	//@Qualifier(id) 
	//Nếu có nhiều hơn một Spring Bean có kiểu phù 
	//hợp với biến thì hệ thống sẽ
	//báo lỗi phải sử dụng đến 2 anotation trên để giải quyết sung đột

	@Bean("messageSource")
	public MessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
		ms.setBasenames("classpath:messages/valid");
		ms.setDefaultEncoding("utf-8");
		return ms;
	}
}