package br.com.brunoKayser.workshopMongoDb.repository;


import br.com.brunoKayser.workshopMongoDb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {


}
