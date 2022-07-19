package com.example.study.service;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

import static org.springframework.web.servlet.function.RequestPredicates.path;
import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@Service
public class RestTempleteService {
    public String getStr() {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                .path("/st")
                .encode()
                .build()
                .toUri();

        RestTemplate rest = new RestTemplate();
        ResponseEntity<String> response = rest.getForEntity(uri,String.class);

        return response.getBody();
    }
}
