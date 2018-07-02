package com.example.demo.repository;

import com.example.demo.entity.ServiceSession;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author koma <komazhang@foxmail.com>
 * @date 2018-07-02 18:16
 */
public class RowMapperForSession implements RowMapper<ServiceSession> {
    @Override
    public ServiceSession mapRow(ResultSet resultSet, int i) throws SQLException {
        ServiceSession serviceSession = new ServiceSession();
        serviceSession.setStopDateTime(resultSet.getTimestamp("createDatetime"));
        return serviceSession;
    }
}
