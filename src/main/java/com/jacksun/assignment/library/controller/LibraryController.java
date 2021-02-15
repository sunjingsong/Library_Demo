package com.jacksun.assignment.library.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jacksun.assignment.library.Entity.Library;
import com.jacksun.assignment.library.dao.BookRepository;
import com.jacksun.assignment.library.dao.LibraryRepository;


@RestController
@RequestMapping("/api/libraries")
public class LibraryController {
	
	private final LibraryRepository libraryRepository;
	private final BookRepository bookRepository;
	
	@Autowired
	public LibraryController(LibraryRepository libraryRepository, 
			BookRepository bookRepository) {
		
		this.libraryRepository = libraryRepository;
		this.bookRepository = bookRepository;
		
	}
	
	@PostMapping
	public ResponseEntity<Library> create(@RequestBody Library library) {
		
		Library savedLibrary = libraryRepository.save(library);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedLibrary.getId()).toUri();
		
		return ResponseEntity.created(location).body(savedLibrary);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Library> update(@PathVariable Integer id, @RequestBody Library library) {
		
		Optional<Library> optionalLibrary = libraryRepository.findById(id);
		if (!optionalLibrary.isPresent()) {
			
			return ResponseEntity.unprocessableEntity().build();
			
		}
		
		library.setId(optionalLibrary.get().getId());
		libraryRepository.save(library);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Library> delete(@PathVariable Integer id) {
		
		Optional<Library> optionalLibrary = libraryRepository.findById(id);
		if (!optionalLibrary.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		libraryRepository.delete(optionalLibrary.get());
		
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Library> getById(@PathVariable Integer id) {
		
		Optional<Library> optionalLibrary = libraryRepository.findById(id);
		if (!optionalLibrary.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		return ResponseEntity.ok(optionalLibrary.get());
		
	}
	
	@GetMapping
	public ResponseEntity<Page<Library>> getAll(Pageable pageable) {
		return ResponseEntity.ok(libraryRepository.findAll(pageable));
	}
}
