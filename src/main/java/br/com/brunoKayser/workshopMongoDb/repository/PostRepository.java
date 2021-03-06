package br.com.brunoKayser.workshopMongoDb.repository;

import br.com.brunoKayser.workshopMongoDb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    //Campo, regex = expressão regular, parâmetro, options = funções de auxilio
    //O nome não importa, des de que faça sentido
    @Query("{'title': {$regex: ?0, $options: i}}")
    List<Post> searchTitle(String text);

    //Pesquisa por método, o método faz consulta ao banco
    //O nome do método importa
    List<Post> findByTitleContainingIgnoreCase(String text);

    //@Query("{ $and: [ { date: {$gte: ?1 } }, { date: { $lte: ?2 } } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    @Query("{ $and: [ { date: {$gte: ?1 } }, { date: { $lte: ?2 } } , { $or: [ { 'title': {$regex: ?0, $options: i } },  {'body': {$regex: ?0, $options: i } } , {'comments.text': {$regex: ?0, $options: i } } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);

}
