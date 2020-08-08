package br.com.brunoKayser.workshopMongoDb.resources;

import br.com.brunoKayser.workshopMongoDb.domain.User;
import br.com.brunoKayser.workshopMongoDb.dto.UserDTO;
import br.com.brunoKayser.workshopMongoDb.dto.UserOptionalDTO;
import br.com.brunoKayser.workshopMongoDb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    //Ou pode usar esta anotação@GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = userService.findAll();
        List<UserDTO> listDTO = list
                                .stream()
                                .map(UserDTO::new).collect(Collectors.toList());
                                // /\ acima é a mesma coisa que abaixo \/
                                //.map(user -> new UserDTO(user)).collect(Collectors.toList());
        return ResponseEntity
                .ok()
                .body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserOptionalDTO> findById(@PathVariable String id){
        Optional<User> obj = userService.findById(id);
        return ResponseEntity.ok().body( new UserOptionalDTO(obj));
    }

}
