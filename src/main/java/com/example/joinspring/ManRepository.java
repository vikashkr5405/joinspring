package com.example.joinspring;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ManRepository extends JpaRepository<Man,Integer>
{

	@Query("select m from man m join m.address a")
	List<Man> getAll();

	@Query("select m from man m join m.address a where m.name like %?1%")
	List<Man> getByName(String name);

	@Query("select m from man m join m.address a where m.name like %:name%")
	List<Man> fetchByName(String name);

	@Query("select m from man m join m.address a where m.address.city like %?1%")
	List<Man> findByCity(String city);

	@Query("select m from man m join m.address a where m.id=?1 and m.age=?2")
	List<Man> getByIdAndAge(int id,int age);

	@Query("select m from man m join m.address a where m.name like %?1% and m.address.city like %?2%")
	List<Man> getByNameAndCity(String name,String city);

	@Query("select m from man m join m.address a where m.id=?1 and m.name=?2")
	List<Man> getByNameAndId(int id,String name);

	@Query("select m from man m join m.address a where m.id=:id")
	List<Man> fetchById(int id);
}

