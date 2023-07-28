package com.example.Auto_Star.repository;

import com.example.Auto_Star.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoRepository extends JpaRepository<Auto, Long>{
    List<Auto> findByName(String title);
}
