package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "test_yang")
public class TestYang {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "area")
    private String area;

    @Column(name = "sortt")
    private int sortt;
}
