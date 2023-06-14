package com.TakeCare.catalog.models.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TakeCare.catalog.models.entities.ChartEntity;
import com.TakeCare.catalog.models.entities.ShopEntity;
import com.TakeCare.catalog.models.entities.UserEntity;

@Repository
public interface ChartRepository extends JpaRepository<ChartEntity,Integer>{

    List<ChartEntity> findByUserId(int id);

    ChartEntity findByUser_idAndId(int UserId, int id);

    
}
