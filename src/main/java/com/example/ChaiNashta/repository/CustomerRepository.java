package com.example.ChaiNashta.repository;

import com.example.ChaiNashta.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,Integer> {
	Optional<Customer> findByCustomerIdAndPassword(Integer customerId, String password);
	Optional<Customer> findByCustomerId(Integer customerId);

}
