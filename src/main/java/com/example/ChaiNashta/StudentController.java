package com.example.ChaiNashta;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class StudentController {

	@Autowired
	StudentRepository srepo;
	@RequestMapping("/test")
	public String test()
	{
		return "this is test for mongodb";
	}
	@PostMapping("/save")
	public String save(@RequestBody Student std)
	{
		std.setId(srepo.findAll().size()+1);
		srepo.save(std);
		return "data saved";
	}
	@GetMapping("/all")
	public List<Student>allData()
	{
		return srepo.findAll();
	}
	@GetMapping("/getUser")
	public Optional<Student> byid(@RequestParam int id)
	{
		return srepo.findById(id);
	}
	@GetMapping("/name/{name}")
	public List<Student>byname(@PathVariable String name)
	{
		return srepo.findByName(name);
	}
	@GetMapping("/city/{city}")
	public List<Student>bycity(@PathVariable String city)
	{
		return srepo.findByCity(city);
	}
	@GetMapping("/both/{name}/{city}")
	public List<Student>both(@PathVariable String name,@PathVariable String city)
	{
		return srepo.findByNameAndCity(name,city);
	}
	@GetMapping("/duo/{city}/{age}")
	public List<Student>duo(@PathVariable String city, @PathVariable int age)
	{
		return srepo.findByCityAndAge(city,age);
	}
	@DeleteMapping("/del/{id}")
	public String del(@PathVariable int id)
	{
		srepo.findById(id).get();
		srepo.deleteById(id);
		return "data deleted";
	}

	@RequestMapping("/upd/{id}")
	public Student update(@RequestBody Student student ,@PathVariable int id)
	{
		Student s=srepo.findById(id).get();
		s.setAge(student.getAge());
		s.setCity(student.getCity());
		s.setName(student.getName());
		return srepo.save(s);
	}
}
