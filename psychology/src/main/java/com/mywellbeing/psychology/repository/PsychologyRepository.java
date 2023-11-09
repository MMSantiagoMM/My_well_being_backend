package com.mywellbeing.psychology.repository;

import com.mywellbeing.psychology.entity.Psychology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
public interface PsychologyRepository extends JpaRepository<Psychology,Long> {
}
