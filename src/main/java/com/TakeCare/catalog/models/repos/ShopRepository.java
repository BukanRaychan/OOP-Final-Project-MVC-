package com.TakeCare.catalog.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TakeCare.catalog.models.entities.ShopEntity;

@Repository
public interface ShopRepository extends JpaRepository<ShopEntity,Integer>{
    
}
