package com.mit.lms.repository;

import com.mit.lms.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String s);

    List<User> findByRole(String role);

    User save(User user);

    User editById(String id);

//    User deleteById(String id);

    User changePassword(String id);

    User reserveBook(String isbn);


    Boolean existsByUsername(String username);
}
