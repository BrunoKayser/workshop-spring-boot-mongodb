package br.com.brunoKayser.workshopMongoDb.resources;

import br.com.brunoKayser.workshopMongoDb.domain.Post;
import br.com.brunoKayser.workshopMongoDb.domain.User;
import br.com.brunoKayser.workshopMongoDb.dto.UserOptionalDTO;
import br.com.brunoKayser.workshopMongoDb.resources.util.URL;
import br.com.brunoKayser.workshopMongoDb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){

        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
