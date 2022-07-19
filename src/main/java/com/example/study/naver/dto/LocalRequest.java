package com.example.study.naver.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Data
@NoArgsConstructor
public class LocalRequest {
    private String query = "";
    private int display = 1;
    private int start=1;
    private String sort = "random";

    public MultiValueMap<String, String> toMultiValueMap(){
        var map = new LinkedMultiValueMap<String, String>();
        map.add("query",query);
        map.add("display", String.valueOf(display));
        map.add("start", String.valueOf(start));
        map.add("sort",sort);
        return map;
    }

}
