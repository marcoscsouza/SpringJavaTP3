package com.marcoscsouza.TP3.domain.repository;

import com.marcoscsouza.TP3.domain.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
