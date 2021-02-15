package com.jacksun.assignment.library.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.jacksun.assignment.library.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> { }
