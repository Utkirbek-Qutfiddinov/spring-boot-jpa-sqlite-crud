package uz.utkirbek.jpaproject.repository;

import uz.utkirbek.jpaproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: utkirbek.
 * Time: 21:59:31
 * Date: July 04, 2023, Tuesday
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
