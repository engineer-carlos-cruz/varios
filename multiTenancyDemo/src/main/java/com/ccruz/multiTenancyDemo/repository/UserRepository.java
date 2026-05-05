package com.ccruz.multiTenancyDemo.repository;

import com.ccruz.multiTenancyDemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
