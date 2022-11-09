package com.sofka.reto1.repository;

import com.sofka.reto1.domain.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {

    public List<Users> findByEmail(String email);

    public List<Users> findByDocument(String document);

}
