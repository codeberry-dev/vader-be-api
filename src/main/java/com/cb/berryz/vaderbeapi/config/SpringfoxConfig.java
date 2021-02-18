package com.cb.berryz.vaderbeapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringfoxConfig {

    @Bean
    public Docket swaggerPlugin() {
        return new Docket(DocumentationType.SWAGGER_2) // SWAGGER_12, SWAGGER_2, SWAGGER_WEBがあるがどれが良いのかあまりわからない
                .select() //ApiSelectorBuilderの生成
                .apis(RequestHandlerSelectors.any()) //ドキュメントの対象となるRequestHandlerを設定
                .paths(PathSelectors.regex("/v1.*")) //ドキュメントの対象となるPathを設定
                .build();
    }

}