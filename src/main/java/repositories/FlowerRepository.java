package repositories;

import java.util.List;
import models.Flower;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

@Repository
public interface FlowerRepository extends MongoRepository<Flower, String> {
     Flower findByName(String name);        
     @Query("{'Notes' : null}")
     List<Flower> findByNotesIsNullQuery();     
     @Query("{'Notes' : {$ne : null}}")
     List<Flower> findByNotesIsNotNullQuery();     
	
}
