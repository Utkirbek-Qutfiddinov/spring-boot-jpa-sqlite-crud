package com.example.jpaproject.repository;

import com.example.jpaproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: utkirbek.
 * Time: 21:59:32
 * Date: July 04, 2023, Tuesday
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
