package com.example.economy.repository;

import com.example.economy.entity.EconomyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EconomyRepository extends JpaRepository<EconomyEntity,Long> {
}
