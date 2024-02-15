package com.speadox.pro.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String url;

    private String category;

    @Column(unique = true)
    private String pName;

    private String pBrand;

    private String imageName;

    private String subDescription;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String reg_date;

    @Column(columnDefinition = "TEXT")
    private String spec;

    private LocalDateTime reg_datetime;

    @Column(unique = true)
    private Long id;
}
