package com.ts.readersHeaven.DTO;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "book")
public class BookDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private long bookId;
	@Column(name = "title")
	private String title;
	@Column(name = "author_id")
	private int authorId;
	@Column(name = "isBn")
	private String isBn;
	@Column(name = "genre")
	private String genre;
	@Column(name = "publication_date")
	private Date publicationDate;
	@Column(name = "price")
	private double price;
	@Column(name = "description")
	private String description;
	@Column(name = "stock_quantity")
	private int stockQuantity;
	@Column(name = "is_out_of_stock")
	boolean isOutOfStock;
	
	
}
