package repositories;

import java.util.List;
import models.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
	Customer findByFirstName(String firstName);
	Customer findByEmail(String email);
	List<Customer> findByLastName(String lastName);
}