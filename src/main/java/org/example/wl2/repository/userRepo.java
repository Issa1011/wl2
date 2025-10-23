package org.example.wl2.repository;

import org.example.wl2.model.userModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class userRepo {
    private final JdbcTemplate jdbcTemplate;
    public userRepo(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<userModel> userModelRowMapper = (rs, rowNum) -> {
        return new userModel(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("passwords")
        );
    };

    public userModel findByUserName(String user){
        String sql = "select * from users where username = ?";
        return jdbcTemplate.queryForObject(sql,userModelRowMapper,user);
    }

    public userModel findByEmail(String email){
        String sql = "select * from users where email = ?";
        return jdbcTemplate.queryForObject(sql,userModelRowMapper,email);
    }


    public boolean validateUser (String username, String passwords){
        String sql = "select count(*) from users where username =? and passwords=?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, username, passwords);
        return count != null && count > 0;

    }

    public int save(userModel user) {
        String sql = "insert into users (username, email, passwords) values(?,?,?)";
        return jdbcTemplate.update(sql,
                user.getUser(),
                user.getEmail(),
                user.getPassword()
        );
    }





}


