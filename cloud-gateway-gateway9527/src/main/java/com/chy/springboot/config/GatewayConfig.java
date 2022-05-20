package com.chy.springboot.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Snickerman
 * @create 2022-05-18 16:18
 * @Description
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customerRoutrLocator(RouteLocatorBuilder rb){
        RouteLocatorBuilder.Builder routes = rb.routes();
        routes.route("path_route_chy",
                r -> r.path("/guonei").
                        uri("http://news.baidu.com/guonei")).build();


        return routes.build();
    }
}
