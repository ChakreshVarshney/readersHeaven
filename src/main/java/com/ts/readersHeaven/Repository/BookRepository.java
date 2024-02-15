package com.ts.readersHeaven.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ts.readersHeaven.DTO.BookDto;

public interface BookRepository extends JpaRepository<BookDto, Long> {
	List<BookDto> findAll();
}
