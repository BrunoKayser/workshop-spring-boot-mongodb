package br.com.brunoKayser.workshopMongoDb.domain;

import br.com.brunoKayser.workshopMongoDb.dto.AuthorDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
@EqualsAndHashCode(of = "id")
public class Post implements Serializable {
    private static final long SerialVersionUID = 1L;

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;

}
