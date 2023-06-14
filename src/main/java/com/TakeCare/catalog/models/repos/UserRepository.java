package com.TakeCare.catalog.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TakeCare.catalog.models.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

     UserEntity findByEmail(String email);
}
