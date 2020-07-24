package com.example.reactive.demo;

import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.http.client.HttpClientResponse;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @RestController
    public static class TestController {
        WebClient webClient = WebClient.create();

        @GetMapping("test")
        public Mono<String> test() {
            return webClient.get().uri("http://127.0.0.1:9999/test").retrieve().bodyToMono(String.class);
        }

        HttpClient httpClient = HttpClient.create();

        @GetMapping("test1")
        public Mono<HttpClientResponse> test1() {
            return httpClient.get().uri("http://127.0.0.1:9999/test").response();
        }

    }
}
