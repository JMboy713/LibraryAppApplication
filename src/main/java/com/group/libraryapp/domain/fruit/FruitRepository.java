package com.group.libraryapp.domain.fruit;

import com.group.libraryapp.dto.example.response.FruitResponse;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long>{
    Fruit findByName(String name);
    List<Fruit> findAllByName(String name);

    int countByName(String name);

    List<Fruit> findAllByPriceGreaterThan(long price);
    List<Fruit> findAllByPriceLessThan(long price);



}
