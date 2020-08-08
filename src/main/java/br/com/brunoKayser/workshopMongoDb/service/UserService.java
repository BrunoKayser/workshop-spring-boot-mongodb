package br.com.brunoKayser.workshopMongoDb.service;


import br.com.brunoKayser.workshopMongoDb.domain.User;
import br.com.brunoKayser.workshopMongoDb.dto.UserDTO;
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

    public void insert(User obj){
        userRepository.insert(obj);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);

    }

    public User update(User obj){
        Optional<User> newObj = userRepository.findById(obj.getId());
        updateData(newObj, obj);
        return userRepository.save(newObj.get());
    }

    private void updateData(Optional<User> newObj, User obj) {
        newObj.get().setName(obj.getName());
        newObj.get().setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(),objDTO.getName(),objDTO.getEmail());
    }

}
