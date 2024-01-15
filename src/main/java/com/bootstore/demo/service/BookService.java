package com.bootstore.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootstore.demo.entity.Book;
import com.bootstore.demo.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public void save(Book b) {
		bookRepository.save(b);
	}
	
	public List<Book> getallBook(){
		return bookRepository.findAll();
	}
	
	public Book getBookById(int id) {
		return bookRepository.findById(id).get();
	}
	
	public void deleteById(int id) {
		bookRepository.deleteById(id);
	}
}
