package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.dto.example.response.FruitSoldResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FruitMysqlRepository implements FruitRepository{
    private final JdbcTemplate jdbcTemplate;
    public FruitMysqlRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void saveFruit(String name,String warehousingDate, long price, boolean sold) {
        String sql = "Insert into fruit(name, warehousingDate, price,sold) Values(?,?,?,?)";
        jdbcTemplate.update(sql, name, warehousingDate, price, sold);

    }

    @Override
    public void sellFruit(long id) {
        String sql = "update fruit set sold = ? where id = ?";
        jdbcTemplate.update(sql, true,id);

    }

    @Override
    public List<FruitSoldResponse> getFruit(String name) {
        String sql ="select"+
                "(select sum(price) from fruit where sold = 1 and name=?) as salesAmount, " +
                "(select sum(price) from fruit where sold = 0 and name=?) as notSalesAmount";

        return jdbcTemplate.query(sql, new Object[]{name,name},(rs, rowNum) -> {
            long salesAmount = rs.getLong("salesAmount");
            long notSalesAmount = rs.getLong("notSalesAmount");
            return new FruitSoldResponse(salesAmount, notSalesAmount);
        });

    }
}
