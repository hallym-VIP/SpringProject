package com.example.study.naver.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ImageResponse {
    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private String category;
    private List<SearchImageItem> items;

    @Data
    @NoArgsConstructor
    public static class SearchImageItem{
        private String title;
        private String link;
        private String thumbnail;
        private String sizeheight;
        private String sizewidth;
    }
}
