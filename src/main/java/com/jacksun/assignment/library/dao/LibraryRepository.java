package com.jacksun.assignment.library.dao;



import org.springframework.data.jpa.repository.JpaRepository;


import com.jacksun.assignment.library.Entity.Library;


public interface LibraryRepository extends JpaRepository<Library, Integer> {
	

}
