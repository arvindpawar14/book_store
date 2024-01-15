package com.bootstore.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootstore.demo.entity.MyBookList;
import com.bootstore.demo.repository.MyBookRepository;

@Service
public class MyBookListService {
	@Autowired
	private MyBookRepository myBookRepository;

	public void saveMyBook(MyBookList books) {
		myBookRepository.save(books);
	}

	public List<MyBookList> getAllMyBooks() {
		return myBookRepository.findAll();
	}
	
	public void deleteById(int id) {
		myBookRepository.deleteById(id);
	}
}
