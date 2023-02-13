package com.example.hibernate.repo;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.hibernate.entity.book;

@Repository
public interface bookrepo extends JpaRepository<book, Integer> {

	public abstract	List<book> findByName(String name);
	public abstract	List<book> findByNameAndPrice(String name,Double price);
	List<book> findByNameEndingWith(String suffix);
	List<book> findByNameLike(String name);
	List<book> findByPriceBetween(Double price1,Double price2);
	List<book> findByPublishdateAfter(Date date);
	
	/*________________________________________________________________*/
	//jpql quries
	
	@Query("from book b where b.name = ?1")
	public abstract List<book> getbook2byname(String name);
	
	@Query("from book b order by b.price")
	public abstract List<book> getbyoreder();
	
	@Query("from book b where b.name like ?1 ")
	public abstract List<book> getnamebyending(String name);
	
	@Query("from book b where b.publishdate >?1")
	public abstract List<book> gatedateafter(Date date);
	
	///////////////////////////////////////////////////////////////////

	@Query("select Author from book b where b.id=?1 ")
	public abstract book getauthorbyid(Integer id);
	
	 @Query("select b from book b join b.Author a where a.id=?1 ")
     public abstract List<book> getBooksByAuthorId(Integer id);
	
	
}
