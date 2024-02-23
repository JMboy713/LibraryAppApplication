package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.dto.example.response.FruitSoldResponse;

import java.util.List;

public interface FruitRepository {

    void saveFruit(String name, String warehousingDate, long price, boolean sold);

    void sellFruit(long id);

    List<FruitSoldResponse> getFruit(String name);

}
