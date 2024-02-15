package com.ts.readersHeaven.Services;

import java.util.List;

import com.ts.readersHeaven.DTO.BookDto;

public interface BookService {
	List<BookDto> findAll();
}
