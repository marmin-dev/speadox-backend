package com.speadox.pro.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_pdf_url")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PdfUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String url;

    private String category;

    private String filename;

    private String pName;

    private String regDate;

    private LocalDateTime regDatetime;

}
