package com.example.study.foodList.repository;

import com.example.study.data.JpaCopyRepositorylmpl;
import com.example.study.foodList.entity.FoodListEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class FoodRepository extends JpaCopyRepositorylmpl<FoodListEntity> {
}
