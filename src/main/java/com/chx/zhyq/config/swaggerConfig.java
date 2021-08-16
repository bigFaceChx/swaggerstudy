package com.chx.zhyq.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class swaggerConfig {
    @Bean
    public Docket docket(Environment environment){
        Profiles dev = Profiles.of("dev");
        boolean flag = environment.acceptsProfiles(dev);
        return  new Docket(DocumentationType.SWAGGER_2)
                .enable(flag)
                .apiInfo(getApiInfo())
                .select()
                //配置扫描方式
                .apis(RequestHandlerSelectors.basePackage("com.chx.zhyq.controller"))
                .build()
                //设置分组
                .groupName("chx")
                ;
    }
    //设置配置信息
    public ApiInfo getApiInfo(){
        return new ApiInfo("chx的swagger接口文档", "辛勤的蜜蜂永远没有时间悲哀", "1.1", "http://github.com/bigFaceChx", new Contact("chx", "www.baidu.com", "1057592614@qq.com"), "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    }
}
