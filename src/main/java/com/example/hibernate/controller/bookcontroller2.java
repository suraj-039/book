package com.example.hibernate.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.hibernate.entity.book;
import com.example.hibernate.repo.bookrepo;

@RestController
public class bookcontroller2 {

	@Autowired
	private bookrepo repo;

	@GetMapping("getbook2byname/{name}")
	public List<book> getbook2byname(@PathVariable(name="name") String name)
	{
		System.out.println(name);
	List<book> book=repo.getbook2byname(name);
	System.out.println(book);
	return book;
	}
	
	@GetMapping("getbook2orderbyprice/{price}")
	public List<book> getbook2orderbyprice()
	{
	List<book> book=repo.getbyoreder();
	System.out.println(book);
	return book;
	}
	
	
	@GetMapping("getnamebyendingwith/{name}")
	public List<book> getnamebyendingwith(@PathVariable(name="name") String name)
	{
		System.out.println(name);
	List<book> book=repo.getnamebyending("%"+name);
	System.out.println(book);
	return book;
	}
	
	@GetMapping("gatedate2after/{datestr}")
	public List<book> findByPublishdateAfter(@PathVariable(name="datestr") String datestr)throws Exception
	{
		SimpleDateFormat format	=new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(datestr);
		List<book> book= repo.gatedateafter(date);
		 return book;
	}
	
	@GetMapping("authorbybid/{id}")
	public book getauthorbybid(@PathVariable Integer id)
	{
		System.out.println(id);
		book b=repo.getauthorbyid(id);
		System.out.println("Book :"+b);
		return b;
	}


	@GetMapping("bookbybamid/{id}")
	public List<book> getbookbyauthorbid(@PathVariable Integer id)
	{
		System.out.println(id);
		List<book> b=repo.getBooksByAuthorId(id);
		System.out.println("Book :"+b);
		return b;
	}


}
