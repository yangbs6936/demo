package com.example.demo;


import com.example.demo.entity.ServiceSession;
import com.example.demo.entity.TestYang;
import com.example.demo.repository.CustomRowMapper;
import com.example.demo.repository.RowMapperForSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


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

    public String getList() {
        String sql = "select * from servicesession where tenantId = ?";
        //在这里断点执行, list可以正常返回，没有报错
        List<ServiceSession> list = jdbcTemplate.query(sql, new RowMapperForSession(), 27);
        return "success";
    }
}
