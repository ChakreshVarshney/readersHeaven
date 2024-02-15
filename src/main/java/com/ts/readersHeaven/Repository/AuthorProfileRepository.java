package com.ts.readersHeaven.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ts.readersHeaven.DTO.AuthorProfileDto;

public interface AuthorProfileRepository extends JpaRepository<AuthorProfileDto,Integer> {

}
