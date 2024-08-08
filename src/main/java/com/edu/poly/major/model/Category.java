package com.edu.poly.major.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    private String name;

}//create table mapping trong db
