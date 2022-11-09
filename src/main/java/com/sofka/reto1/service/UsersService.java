package com.sofka.reto1.service;

import com.sofka.reto1.domain.Users;
import com.sofka.reto1.exception.BusinessException;
import com.sofka.reto1.exception.general.BadRequestException;
import com.sofka.reto1.exception.general.NotFoundException;
import com.sofka.reto1.repository.UsersRepository;
import com.sofka.reto1.service.inter.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements IUsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> getUsersById(String Id) {
        return usersRepository.findById(Id);
    }

    @Override
    public Users createUser(Users user) throws BusinessException {
        Boolean emailExist = usersRepository.findByEmail(user.getEmail()).isEmpty();
        Boolean documentExist = usersRepository.findByDocument(user.getDocument()).isEmpty();
        if (emailExist || documentExist) {
            return usersRepository.insert(user);
        } else {
            throw new BadRequestException("Email or document already exists");
        }
    }

    @Override
    public void deleteUsersById(String Id) throws BusinessException {
        Users user = usersRepository.findById(Id).orElseThrow();
        user.setState(0);
        usersRepository.save(user);
    }

    @Override
    public Users updateUser(Users user) throws BusinessException {
        if (usersRepository.findById(user.getId()).isPresent()) {
            return usersRepository.save(user);
        } else {
            throw new NotFoundException("User not found");
        }
    }

}
