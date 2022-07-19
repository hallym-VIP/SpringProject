package com.example.study.naver;

import com.example.study.naver.dto.ImageRequest;
import com.example.study.naver.dto.ImageResponse;
import com.example.study.naver.dto.LocalRequest;
import com.example.study.naver.dto.LocalResponse;
import lombok.Data;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.ParameterizedType;
import java.net.URI;


@Service
@Data
public class NaverHttp {
    private String naverLocalUri = "https://openapi.naver.com/v1/search/local.json";
    private String naverImageUri = "https://openapi.naver.com/v1/search/image";
    private String naverID = "lBKsCY1eJKBsuFPDvWRK";
    private String naverSecret = "";

    public LocalResponse localSearch(LocalRequest request){
        URI uri = UriComponentsBuilder
                .fromUriString(naverLocalUri)
                .queryParams(request.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", naverID);
        headers.set("X-Naver-Client-Secret", naverSecret);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<LocalResponse>(){

        };

        ResponseEntity<LocalResponse> responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );
        return responseEntity.getBody();

    }
    public ImageResponse imageResponse(ImageRequest request) {
        URI uri = UriComponentsBuilder
                .fromUriString(naverImageUri)
                .queryParams(request.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", naverID);
        headers.set("X-Naver-Client-Secret", naverSecret);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<ImageResponse>() {

        };

        var responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );
        return responseEntity.getBody();
    }

}
