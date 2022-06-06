package SOF3021.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
 
@Configuration
public class TilesConfig {
	@Bean(name = "viewResolver")
    public ViewResolver getViewResolver() {
//        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
//        viewResolver.setViewClass(TilesView.class);
		TilesViewResolver viewResolver = new TilesViewResolver();
        return viewResolver;
    }
 
    @Bean(name = "tilesConfigurer")
    public TilesConfigurer getTilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/views/tiles.xml");
        return tilesConfigurer;
    }
}
