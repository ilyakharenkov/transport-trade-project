package com.example.transporttrade.repository;


import com.example.transporttrade.entity.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransportRepository extends JpaRepository<Transport, Long>{

    List<Transport> findByBrandOrModelOrCategoryOrNumberOrType(String brand, String model, String category, String number, String type);

    List<Transport> findByBrandOrModelOrCategoryOrNumberOrYear(String brand, String model, String category, String number, int year);


}
