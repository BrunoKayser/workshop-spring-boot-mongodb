package br.com.brunoKayser.workshopMongoDb.service;


import br.com.brunoKayser.workshopMongoDb.domain.User;
import br.com.brunoKayser.workshopMongoDb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
