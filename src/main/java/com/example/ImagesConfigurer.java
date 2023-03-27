package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImagesConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);

        // doble asteristico significa q recursos estan en carperta recursos y todo lo q haya por debajo
        registry.addResourceHandler("/resources/**")
        .addResourceLocations("file:"+ "//home//jalendem//Recursos/");
    }

}
