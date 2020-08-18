package br.com.brunoKayser.workshopMongoDb.service;


import br.com.brunoKayser.workshopMongoDb.domain.Post;
import br.com.brunoKayser.workshopMongoDb.domain.User;
import br.com.brunoKayser.workshopMongoDb.dto.UserDTO;
import br.com.brunoKayser.workshopMongoDb.repository.PostRepository;
import br.com.brunoKayser.workshopMongoDb.repository.UserRepository;
import br.com.brunoKayser.workshopMongoDb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository userRepository;

    public Optional<Post> findById(String id){
        Optional<Post> post = userRepository.findById(id);
            if (post
                    .isEmpty()){
                throw new ObjectNotFoundException("Objeto não encontrado");
            }
            return post;
    }

}
