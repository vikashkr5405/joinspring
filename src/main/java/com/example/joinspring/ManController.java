package com.example.joinspring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManController {
@Autowired
ManRepository mrepo;
@Autowired
AddressRepository arepo;

@RequestMapping("/adddetails")
public String save()
{
	Man m=new Man();
	m.setName("anshu sharma");
	m.setAge(18);
	Address a=new Address();
	a.setCity("Noida");
	a.setCountry("india");
	m.setAddress(a);
	a.setMan(m);
	
	mrepo.save(m);
	return "data is saved.................!";
}
@RequestMapping("/findAll")
public List<Man> findAll()
{
	return mrepo.findAll();
}
@RequestMapping("/find")
public List<Address> find()
{
	return arepo.findAll();
}

@RequestMapping("/getAll")
List<Man> show()
{
	return mrepo.getAll();
}
@RequestMapping("/get/{name}")
public List<Man> getall(@PathVariable String name)
{
	return mrepo.getByName(name);
}
@RequestMapping("/fetch/{name}")
public List<Man> fetchByName(@PathVariable String name)
{
	return mrepo.fetchByName(name);
}
@RequestMapping("/find/{city}")
public List<Man> findByCity(@PathVariable String city)
{
	return mrepo.findByCity(city);
}
@RequestMapping("/getBy/{id}/{age}")
public List<Man> getByIdAndAge(@PathVariable int id,@PathVariable int age)
{
	return mrepo.getByIdAndAge(id, age);
}
@RequestMapping("/{name}/{city}")
public List<Man> getByNameAndCity(@PathVariable String name,@PathVariable String city)
{
	return mrepo.getByNameAndCity(name, city);
}
@RequestMapping("/get/{id}/{name}")
public List<Man> getByNameAndId(@PathVariable int id,@PathVariable String name)
{
	return mrepo.getByNameAndId(id, name);
}
@RequestMapping("/from/{id}")
public List<Man> fetchById(@PathVariable int id)
{
	return mrepo.fetchById(id);
}
}
