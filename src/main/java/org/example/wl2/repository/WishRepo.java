package org.example.wl2.repository;

import org.example.wl2.model.WishlistModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class WishRepo {
    private final JdbcTemplate jdbcTemplate;

    public WishRepo(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<WishlistModel> wishlistRowMapper= (rs, rowNum) -> {
        return new WishlistModel(
                rs.getString("wishName"),
                rs.getString("descriptions"),
                rs.getDouble("prices"),
                rs.getString("link")
        );
    };

    public List<WishlistModel> findAll(){
        String sql = "select * from Wish";
        return jdbcTemplate.query(sql,)
    }


}
