package com.example.reactive.demo;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Cantos Song created on 2020/7/25
 * @version $
 */
@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("test2", r -> r.path("/test2").filters(
                        f -> f.rewritePath("/test2", "/test")
                                .removeRequestHeader("Expect")
                ).uri("http://127.0.0.1:9999")).build();
    }

}
