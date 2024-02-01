package com.speadox.pro.repositories;

import com.speadox.pro.entities.PdfUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdfRepository extends JpaRepository<PdfUrl,String> {
}
