package com.group.libraryapp.domain.fruit;

import com.group.libraryapp.dto.example.response.FruitSoldResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long>{
    Fruit findByName(String name);
    List<Fruit> findAllByName(String name);


}
