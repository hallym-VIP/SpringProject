package com.example.study.controller;

import com.example.study.foodList.dto.FoodListDto;
import com.example.study.service.FoodListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class FrontController {

    private final FoodListService foodListService;

    @GetMapping
    public FoodListDto localSearch(@RequestParam String query){
        return foodListService.localSearch(query);
    }
    @PostMapping
    public FoodListDto saveData(@RequestBody FoodListDto dto){
        var result = foodListService.saveService(dto);
        log.info("save 성공 ----> {}",result);
        return result;
    }




}
