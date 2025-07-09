package com.fealtyx.fealtyx.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;


public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("FealtyX Student API")
                        .version("1.0")
                        .description("CRUD API with AI summary using Ollama"));
    }
}
