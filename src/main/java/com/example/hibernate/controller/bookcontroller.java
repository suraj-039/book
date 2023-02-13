package com.example.hibernate.controller;


import java.io.FileNotFoundException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hibernate.aspects.LoggerAspect;
import com.example.hibernate.entity.book;
import com.example.hibernate.repo.bookrepo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class bookcontroller {
	
	@Autowired
	private bookrepo Bookrepo;
	
	//private final static Logger LOGGER=LoggerFactory.getLogger(bookcontroller.class);
	@PostMapping("savebook")
	
	public ResponseEntity<book> savebook(@RequestBody book Book)
	{
		Book.setPublishdate(new Date());
		System.out.println(Book);
		Bookrepo.save(Book);
		ResponseEntity<book> re=new ResponseEntity<book>(Book, HttpStatus.OK);
 		return re;
	}
	
  	@GetMapping("getbyid")
	public ResponseEntity<Optional<book>> getbyid(@RequestParam(name="id") Integer id) throws FileNotFoundException
	{
		
		Optional<book> Book = Bookrepo.findById(id);
		log.trace("getbyid");
		log.debug("getbyid");
		log.info("getbyid");

		log.warn("getbyid");
		
		if (Book.isPresent())
		{
			System.out.println(Book);
			ResponseEntity<Optional<book>> re=new ResponseEntity<>(Book,HttpStatus.OK);
	 		return re;
		}
		else {
			System.out.println("book not found");
			
			return null;
		}
		
	}

	@PostMapping("savebooks")
	public ResponseEntity<List<book>> savebooks(@RequestBody List<book> Book)
	{
		
		Bookrepo.saveAll(Book);
		
		ResponseEntity<List<book>> re=new ResponseEntity<>(Book, HttpStatus.OK);
 		return re;
		
	}
	
	@GetMapping("getAll")
	public ResponseEntity< List<book>> getall()
	{
		
		List<book> Book= Bookrepo.findAll();
		
		ResponseEntity<List<book>> re=new ResponseEntity<>(Book, HttpStatus.OK);
 		return re;
		
	}
	
	@DeleteMapping("deletbook")
	public ResponseEntity<book> deletBook(@RequestBody book Book)
	{
		
		Bookrepo.delete(Book);
		ResponseEntity<book> re=new ResponseEntity<>(Book, HttpStatus.OK);
 		return re;
		
	}

	
		@GetMapping("getbyName/{name}")
	public ResponseEntity<List<book>>getbyName(@PathVariable String name)
	{
	  List<book> books=	Bookrepo.findByName(name);
	  ResponseEntity<List<book>> re=new ResponseEntity<>(HttpStatus.OK);
		return re;
	}
	
	@GetMapping("getbyNameprice/{name}/{price}")
	public List<book> getbyNameandprice(@PathVariable String name,@PathVariable Double price)
	{
		System.out.println(name+" "+price);
	  List<book> books=	Bookrepo.findByNameAndPrice(name,price);
	  System.out.println(books);
	  return books;
	}

	@GetMapping("getnamewithlast/{endwith}")
	public List<book> getwithendWith(@PathVariable String endwith)
	{
		
	
		List<book> names= Bookrepo.findByNameEndingWith(endwith);
		System.out.println(names);
		return names;
		
	}
	

	@GetMapping("getnamebylike/{name}")
	public List<book> getbookbylike(@PathVariable String name)
	{
		
	
		List<book> names= Bookrepo.findByNameLike("%"+name+"%");
		System.out.println(names);
		return names;
		
	}

	@GetMapping("getprice/{p1}/{p2}")
	public ResponseEntity< List<book>> getbypricebetween(@PathVariable Double p1,@PathVariable Double p2)
	{
		List<book> books=Bookrepo .findByPriceBetween(p1, p2);
		ResponseEntity<List<book>> re=new ResponseEntity<>(books, HttpStatus.OK);
 		return re;
		
		
	}
	
	@GetMapping("gatedateafter/{datestr}")
	public List<book> findByPublishdateAfter(@PathVariable(name="datestr") String datestr)throws Exception
	{
 SimpleDateFormat format	=new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(datestr);
		List<book> book= Bookrepo.findByPublishdateAfter(date);
		 return book;
	}
	
	

}
