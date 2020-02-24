package wcaa.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

    //配置Tomcat的虚拟目录
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
        .addResourceLocations("classpath:/META-INF/resources/")
        .addResourceLocations("file:C:/DRF/touxiang/");
    }
}
