package com.example.demo;


import com.example.demo.entity.TestYang;
import com.example.demo.repository.CustomRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class JDBCTemplate {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public String getResult() {
        String sql = "select * from test_yang where area= ?";
        String parm = "faefawef";
        jdbcTemplate.query(sql, new CustomRowMapper<TestYang>(), parm);
        return "success";
    }

}
