package br.com.brunoKayser.workshopMongoDb.repository;

import br.com.brunoKayser.workshopMongoDb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {



}
