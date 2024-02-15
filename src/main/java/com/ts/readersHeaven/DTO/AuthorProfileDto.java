package com.ts.readersHeaven.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "author_profile")
public class AuthorProfileDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authorId;
	@Column(name = "author_ame")
	private String authorName;
	@Column(name = "biography")
	private String biography;
	@Column(name = "published_work")
	private String publishedWork;
	@Column(name = "awards_recognition")
	private String awardsRecognition;
}
