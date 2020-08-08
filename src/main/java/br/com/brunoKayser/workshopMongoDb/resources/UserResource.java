package br.com.brunoKayser.workshopMongoDb.resources;

import br.com.brunoKayser.workshopMongoDb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    //Ou pode usar esta anotação@GetMapping
    public ResponseEntity<List<User>> findAll() {
        var maria = new User("1", "Maria Brown", "Maria@gmail.com");
        var alex = new User("2", "Alex Green", "Alex@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list);
    }
}
