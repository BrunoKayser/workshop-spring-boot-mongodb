package br.com.brunoKayser.workshopMongoDb.resources;

import br.com.brunoKayser.workshopMongoDb.domain.Post;
import br.com.brunoKayser.workshopMongoDb.domain.User;
import br.com.brunoKayser.workshopMongoDb.dto.UserOptionalDTO;
import br.com.brunoKayser.workshopMongoDb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){

        Optional<Post> obj = postService.findById(id);
        return ResponseEntity.ok().body(obj.get());
    }
}
