package com.example.ChaiNashta;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,Integer>{

	List<Student> findByName(String name);

	List<Student> findByCity(String city);

	List<Student> findByNameAndCity(String name, String city);

	List<Student> findByCityAndAge(String city, int age);

	Optional<Student> findAllById(String id);

}
