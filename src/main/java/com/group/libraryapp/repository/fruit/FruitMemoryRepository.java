package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.dto.example.response.FruitSoldResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
@Primary
@Repository
public class FruitMemoryRepository implements FruitRepository{
    @Override
    public void saveFruit(String name, String warehousingDate, long price, boolean sold) {

    }

    @Override
    public void sellFruit(long id) {

    }

    @Override
    public List<FruitSoldResponse> getFruit(String name) {
        return null;
    }
}
