package com.mywellbeing.user.repository;

import com.mywellbeing.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
