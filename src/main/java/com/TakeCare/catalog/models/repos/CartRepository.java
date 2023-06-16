package com.TakeCare.catalog.models.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TakeCare.catalog.models.entities.CartEntity;
import com.TakeCare.catalog.models.entities.ShopEntity;
import com.TakeCare.catalog.models.entities.UserEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity,Integer>{

    List<CartEntity> findByUserId(int id);

    CartEntity findByUser_idAndId(int UserId, int id);

    @Modifying
    @Query("DELETE FROM CartEntity c WHERE c.id = :id")
    void deleteById(int id);


    @Query("SELECT COALESCE(SUM(c.price * c.quantity), null) FROM CartEntity c")
    Double getTotalPriceSum();
}
