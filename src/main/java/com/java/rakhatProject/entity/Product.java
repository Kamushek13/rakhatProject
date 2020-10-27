package com.java.rakhatProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id")
    private long id;

 /*   @Column(name = "image")
    private byte image;*/

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "weight")
    private double weight;

    @Column(name = "unit")
    private String unit;

    @Column(name = "composition")
    private String composition;

    @Column(name = "category_id")
    private long categoryId;

    @Column(name = "price")
    private double price;

    @Column(name = "stock")
    private long stock;
}
