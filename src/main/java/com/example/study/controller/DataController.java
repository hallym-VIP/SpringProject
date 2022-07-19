package com.example.study.controller;


import com.example.study.service.FoodListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
public class DataController {
         private final FoodListService foodListService;
        @GetMapping("/main")
        public String model(){
            return "index";
        }

        @GetMapping("/result")
        public String result(Model model){
            var list = foodListService.findAll();
            model.addAttribute("list",list);
            return "result";
        }
}
