package com.ts.readersHeaven.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ts.readersHeaven.DTO.BookDto;
import com.ts.readersHeaven.Repository.BookRepository;

public class BookServiceImpl implements BookService {
	@Autowired
	BookRepository bookRepository;
	
	
	public List<BookDto> findAll(){
		return bookRepository.findAll();
	}
}
