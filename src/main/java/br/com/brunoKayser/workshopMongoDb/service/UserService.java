package br.com.brunoKayser.workshopMongoDb.service;


import br.com.brunoKayser.workshopMongoDb.domain.User;
import br.com.brunoKayser.workshopMongoDb.repository.UserRepository;
import br.com.brunoKayser.workshopMongoDb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();

    }

    public Optional<User> findById(String id){
        Optional<User> user = userRepository.findById(id);
            if (user.isEmpty()){
                throw new ObjectNotFoundException("Objeto não encontrado");
            }
            return user;
    }
}
