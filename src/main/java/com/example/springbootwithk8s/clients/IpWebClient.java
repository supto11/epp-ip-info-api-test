package com.example.springbootwithk8s.clients;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class IpWebClient {

    private final WebClient webClient;

    public Mono<Object> getIpInfo(String ip) {
        return webClient.get().uri("//ip-api.com/json/" + ip +"?fields=status,message,continent,continentCode,country,countryCode,region,regionName,city,district,zip,lat,lon,timezone,offset,currency,isp,org,as,asname,reverse,mobile,proxy,hosting,query&lang=en")
                .retrieve().bodyToMono(Object.class);
    }

}
