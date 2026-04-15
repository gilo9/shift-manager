package mwa.giles.shiftmanager.repository;

import mwa.giles.shiftmanager.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findEmployeeByEmail(String Email);


    boolean existsByEmail(String email);
}
