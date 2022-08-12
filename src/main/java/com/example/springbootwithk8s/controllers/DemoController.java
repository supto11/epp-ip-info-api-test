package com.example.springbootwithk8s.controllers;

import com.example.springbootwithk8s.clients.IpWebClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final IpWebClient ipWebClient;

    @GetMapping("/")
    public Mono<Object> hello(ServerHttpRequest serverHttpRequest) {
        String ip = serverHttpRequest.getRemoteAddress() == null ? "localhost" : serverHttpRequest.getRemoteAddress().getAddress().getHostAddress();
        return ipWebClient.getIpInfo(ip)
                .onErrorReturn("Error while getting ip info");
    }
}
