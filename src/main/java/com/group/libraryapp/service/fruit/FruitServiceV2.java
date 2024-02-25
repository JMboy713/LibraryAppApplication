package com.group.libraryapp.service.fruit;

import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.domain.fruit.FruitRepository;
import com.group.libraryapp.dto.example.request.FruitRequest;
import com.group.libraryapp.dto.example.request.FruitUpdateRequest;
import com.group.libraryapp.dto.example.response.FruitCountResponse;
import com.group.libraryapp.dto.example.response.FruitResponse;
import com.group.libraryapp.dto.example.response.FruitSoldResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FruitServiceV2 {
    private final FruitRepository fruitRepository;

    public FruitServiceV2(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Transactional
    public void saveFruit(FruitRequest request) {
        Fruit f = fruitRepository.save(new Fruit(request.getName(), request.getWarehousingDate(), request.getPrice()));
    }

    @Transactional
    public void sellFruit(FruitUpdateRequest request) {
        Fruit fruit = fruitRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new); // 없다면 예외 던지기
        fruit.updatesold(true);
        fruitRepository.save(fruit);
    }

    @Transactional(readOnly = true)
    public FruitSoldResponse getFruit(String name) {
        List<Fruit> fruits = fruitRepository.findAllByName(name);

        long salesAmount = fruits.stream()
                .filter(Fruit::Solden)
                .mapToLong(Fruit::getPrice)
                .sum();

        long notSalesAmount = fruits.stream()
                .filter(fruit -> !fruit.Solden())
                .mapToLong(Fruit::getPrice)
                .sum();
        return new FruitSoldResponse(salesAmount, notSalesAmount);
    }

    public FruitCountResponse getFruitCount(String name) {
        return new FruitCountResponse(fruitRepository.countByName(name));
    }

    public List<Fruit> getFruits(String option, long price) {
        if (option.equals("GTE")) {
            return fruitRepository.findAllByPriceGreaterThan(price);
        }
        return fruitRepository.findAllByPriceLessThan(price);
    }
}
