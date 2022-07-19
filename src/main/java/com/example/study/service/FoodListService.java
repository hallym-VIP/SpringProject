package com.example.study.service;

import com.example.study.data.JpaCopyRepository;
import com.example.study.foodList.dto.FoodListDto;
import com.example.study.foodList.entity.FoodListEntity;
import com.example.study.foodList.repository.FoodRepository;
import com.example.study.naver.NaverHttp;
import com.example.study.naver.dto.ImageRequest;
import com.example.study.naver.dto.LocalRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodListService {
    private final NaverHttp naverHttp;

    private final FoodRepository repository;
    public FoodListDto localSearch(String query){
        LocalRequest request = new LocalRequest();
        request.setQuery(query);
        var result = naverHttp.localSearch(request);
        var resultLocal = result.getItems().stream().findFirst().get();
        System.out.println(resultLocal);
        var imageQuery =
                resultLocal.getTitle().replace("<[^>]*>","");
        var imageRequest = new ImageRequest();
        imageRequest.setQuery(imageQuery);

        var resultImage = naverHttp.imageResponse(imageRequest);


        var imageItem = resultImage.getItems().stream().findFirst().get();
        var resultDto = new FoodListDto();
        resultDto.setTitle(resultLocal.getTitle());
        resultDto.setCategory(resultLocal.getCategory());
        resultDto.setAddress(resultLocal.getAddress());
        resultDto.setRoadAddress(resultLocal.getRoadAddress());
        resultDto.setHomepageLink(resultLocal.getLink());
        resultDto.setImageLink(imageItem.getLink());

        return resultDto;
    }

    public FoodListDto saveService(FoodListDto dto){
            var entity = dtoToEntity(dto);
            var saveEntity =repository.save(entity);
            return entityToDto(saveEntity);
    }
    public List<FoodListEntity> findAll(){
        return repository.findAll();
    }
    public String strReplace(String html){
        html.replaceAll("<>gtb","");
        return html;
    }
    private FoodListEntity dtoToEntity(FoodListDto wishListEntityDto){    //dto 클래스를 Entity로 바꿔서 저장한다 둘에 차이는 MemoryDb를 상속받냐 안받냐차이다
        //dto를 Entitiy객체로
        var entity = new FoodListEntity();
        entity.setIndex(wishListEntityDto.getIndex());
        entity.setTitle(wishListEntityDto.getTitle());
        entity.setCategory(wishListEntityDto.getCategory());
        entity.setAddress(wishListEntityDto.getAddress());
        entity.setRoadAddress(wishListEntityDto.getRoadAddress());
        entity.setHomepageLink(wishListEntityDto.getHomepageLink());
        entity.setImageLink(wishListEntityDto.getImageLink());
        entity.setVisit(wishListEntityDto.isVisit());
        entity.setVisitCount(wishListEntityDto.getVisitCount());

        return entity;
    }

    private FoodListDto entityToDto(FoodListEntity wishListEntity){
        //entity를 dto객체로 바꾼다
        var dto = new FoodListDto();
        dto.setIndex(wishListEntity.getIndex());
        dto.setTitle(wishListEntity.getTitle());
        dto.setCategory(wishListEntity.getCategory());
        dto.setAddress(wishListEntity.getAddress());
        dto.setRoadAddress(wishListEntity.getRoadAddress());
        dto.setHomepageLink(wishListEntity.getHomepageLink());
        dto.setImageLink(wishListEntity.getImageLink());
        dto.setVisit(wishListEntity.isVisit());
        dto.setVisitCount(wishListEntity.getVisitCount());

        return dto;

    }

}
