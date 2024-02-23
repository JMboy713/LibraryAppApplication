package com.group.libraryapp.service.fruit;

import com.group.libraryapp.dto.example.request.FruitRequest;
import com.group.libraryapp.dto.example.request.FruitSoldRequest;
import com.group.libraryapp.dto.example.request.FruitUpdateRequest;
import com.group.libraryapp.dto.example.response.FruitSoldResponse;
import com.group.libraryapp.repository.fruit.FruitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {
    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository){
        this.fruitRepository = fruitRepository;
    }

    public void saveFruit(FruitRequest request){
        fruitRepository.saveFruit(request.getName(), request.getWarehousingDate(), request.getPrice(), false);
    }
    public void sellFruit(FruitUpdateRequest request){
        fruitRepository.sellFruit(request.getId());

    }
    public List<FruitSoldResponse> getFruit(String name){
        return fruitRepository.getFruit(name);
    }

}
