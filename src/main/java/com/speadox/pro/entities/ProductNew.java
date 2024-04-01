package com.speadox.pro.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductNew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productNo;

    @Column(nullable = false)
    private String url;

    private String category;

    @Column(nullable = false)
    private String pName;

    private String pdfName;

    private String description;

    private String imageName;

    private String pBrand;

    private String subDescription;

    private String spec;

    private String regDate;



}
