package com.marcoscsouza.TP3.domain.repository;

import com.marcoscsouza.TP3.domain.model.Employeer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeerRepository extends JpaRepository<Employeer, Long> {
}
