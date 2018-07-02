package com.example.demo.repository;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomRowMapper<TestYang> implements RowMapper<TestYang> {

    @Override
    public TestYang mapRow(ResultSet resultSet, int i) throws SQLException {
        resultSet.getString("AREA");
        System.out.println(resultSet);
        return null;
    }
}
