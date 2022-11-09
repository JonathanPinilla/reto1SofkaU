package com.sofka.reto1.service.inter;

import com.sofka.reto1.domain.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IUsersService {

    public List<Users> findAll();

    public Optional<Users> getUsersById(String Id);

    public Users createUser(Users user) throws IllegalArgumentException;

    public void deleteUsersById(String Id);

    public List<Users> findByEmail(String email);
}
