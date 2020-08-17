package br.com.brunoKayser.workshopMongoDb.dto;


import br.com.brunoKayser.workshopMongoDb.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class AuthorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public AuthorDTO(User user){
        id = user.getId();
        name = user.getName();
    }

}
