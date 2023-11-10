package com.example.economy.repository;

import com.example.economy.entity.EconomyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EconomyRepository extends JpaRepository<EconomyEntity,Long> {
}
