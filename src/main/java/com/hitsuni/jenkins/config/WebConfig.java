package com.hitsuni.jenkins.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    // 다른 서버에서 넘어오는 통신을 허용하는 설정
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                /* NodePort 설정으로 처리할 때는 Origin이 달라서 CORS 처리가 필요함 */
                //.allowedOrigins("http://localhost:30000")
                /* Ingress 설정시 단일 진입점을 사용하므로 CORS 처리가 불필요함
                * 다만 다른 CORS 처리가 필요할 가능성을 염두해 두고 코드만 남겨놓았음 */
                .allowedOrigins()
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
