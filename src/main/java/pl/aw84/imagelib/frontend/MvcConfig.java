package pl.aw84.imagelib.frontend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    @Value("${imageSourceHost}")
    String imageSourceHost;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        WebMvcConfigurer.super.addResourceHandlers(registry);

        registry.addResourceHandler("/i/**")
                .addResourceLocations(new FileSystemResource(this.imageSourceHost));
        registry.addResourceHandler("/s/**")
                .addResourceLocations(new ClassPathResource("static/"));
        registry.addResourceHandler("/**")
                .addResourceLocations(new ClassPathResource("static/"));
    }
}