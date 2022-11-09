package com.sofka.reto1.service;

import com.sofka.reto1.domain.Users;
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
    public List<Users> findAll(){
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> getUsersById(String Id){
        return usersRepository.findById(Id);
    }

    @Override
    public Users createUser(Users user) throws IllegalArgumentException {
        user.setState(1);
        if(usersRepository.findByEmail(user.getEmail()).isEmpty()){
            return usersRepository.insert(user);
        }else{
            throw new IllegalArgumentException("Email already exists");
        }
    }

    @Override
    public void deleteUsersById(String Id){
        usersRepository.deleteById(Id);
    }

    @Override
    public List<Users> findByEmail(String email){
        return usersRepository.findByEmail(email);
    }

}
