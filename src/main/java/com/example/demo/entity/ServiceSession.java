package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author koma <komazhang@foxmail.com>
 * @date 2018-07-02 18:08
 */
@Data
public class ServiceSession {
    private Integer tenantId;
    private String serviceSessionId;
    private Date createDatetime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date stopDateTime;
}
