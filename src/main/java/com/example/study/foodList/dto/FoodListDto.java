package com.example.study.foodList.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class FoodListDto {
    private Integer index;
    private String title;
    private String category;
    private String address;
    private String roadAddress;
    private String homepageLink;
    private String imageLink;
    private boolean isVisit;
    private int visitCount;
}
