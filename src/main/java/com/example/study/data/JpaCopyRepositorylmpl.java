package com.example.study.data;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaCopyRepositorylmpl <T extends DbEntity> implements JpaCopyRepository<T>{

    private final List<T> db = new ArrayList<>();
    private int index=0;

    @Override
    public Optional<T> findById(int index){
        return db.stream().filter(it->it.getIndex() == index).findFirst();
    }

    @Override
    public T save(T entity){
        Optional<T> optionalResult = db.stream().filter(it->it.getIndex()==entity.getIndex()).findFirst();

        if(optionalResult.isEmpty()){
            index++;
            entity.setIndex(index);
            db.add(entity);
            return entity;
        }else{
            var preIndex = optionalResult.get().getIndex();
            entity.setIndex(preIndex);

            deleteById(preIndex);
            db.add(entity);
            return entity;
        }
    }

    @Override
    public void deleteById(int index){
        db.remove(index);
    }

    @Override
    public List<T> findAll(){
        return db;
    }
}
