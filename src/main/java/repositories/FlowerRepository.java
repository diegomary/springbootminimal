package repositories;

import java.util.List;
import models.Flower;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface FlowerRepository extends MongoRepository<Flower, String> {
	//Flower findByName(String name);
	
}
