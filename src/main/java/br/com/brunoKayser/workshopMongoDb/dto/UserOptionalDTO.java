package br.com.brunoKayser.workshopMongoDb.dto;


import br.com.brunoKayser.workshopMongoDb.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@NoArgsConstructor
@Getter
@Setter
public class UserOptionalDTO {
    private static final long serialVersionUID =1L;

    private String id;
    private String name;
    private String email;

    public UserOptionalDTO(Optional<User> obj){
        id = obj.get().getId();
        name = obj.get().getName();
        email = obj.get().getEmail();
    }
}
