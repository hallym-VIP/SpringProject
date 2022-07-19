package com.example.study.naver.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class LocalResponse {
    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<SearchLocalItem> items;

    @Data
    @NoArgsConstructor
    public static class SearchLocalItem{
        private String title;
        private String link;
        private String category;
        private String description;
        private String telephone;
        private String address;
        private String roadAddress;
        private int mapx;
        private int mapy;

    }
}
