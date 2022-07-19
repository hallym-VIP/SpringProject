package com.example.study.foodList.entity;

import com.example.study.data.DbEntity;
import lombok.Data;

@Data
public class FoodListEntity extends DbEntity {
    private String title; //음식명,장소명
    private String category; //카테고리
    private String address;		//주소
    private String roadAddress;	//도로명 주소
    private String homepageLink;	//홈페이지주소
    private String imageLink; //음식,가게 임지ㅣ 주소
    private boolean isVisit; //방문여부
    private int visitCount; //방문 카운트
}
