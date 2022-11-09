package com.sofka.reto1.service.inter;

import com.sofka.reto1.domain.Users;
import com.sofka.reto1.exception.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IUsersService {

    public List<Users> findAll();

    public Optional<Users> getUsersById(String Id);

    public Users createUser(Users user) throws BusinessException;

    public void deleteUsersById(String Id) throws BusinessException;

    Users updateUser(Users user) throws BusinessException;
}
