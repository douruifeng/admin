package wcaa.api;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

	/**
	 * @Description:swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
	 */
	@Bean
	public Docket createRestApi() {
		
		// 为swagger添加header参数可供输入  
       /* ParameterBuilder userTokenHeader = new ParameterBuilder();
        ParameterBuilder userIdHeader = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();  
        userTokenHeader.name("headerUserToken").description("userToken")
        	.modelRef(new ModelRef("string")).parameterType("header")
        	.required(false).build();  
        userIdHeader.name("headerUserId").description("userId")
	    	.modelRef(new ModelRef("string")).parameterType("header")
	    	.required(false).build(); 
        pars.add(userTokenHeader.build());
        pars.add(userIdHeader.build());*/
		
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("wcaa.api.controller"))
				.paths(PathSelectors.any()).build();
				//.globalOperationParameters(pars);
	}

	/**
	 * @Description: 构建 api文档的信息
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				// 设置页面标题
				.title("使用swagger2构建后端管理平台api接口文档,开发人员：豆瑞锋,李伟")
				// 设置联系人
				.contact(new Contact("ruifeng_dou", "www.narrey.com", "dou_email@163.com"))
				// 描述
				.description("欢迎访问后台管理平台接口文档，本文档提供对外的接口")
				// 定义版本号
				.version("1.0").build();
	}

}
