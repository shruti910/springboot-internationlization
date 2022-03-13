package com.international.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDto {
	
	
	private String greetings;

	private String title;
	
	private String productName;
	
	private String productPrice;
	
	private String productLastupdated;
	
	private String chooseLang;

	public ProductDto() {
		super();
		
	}

	public ProductDto(String greetings, String title) {
		super();
		this.greetings = greetings;
		this.title = title;
	}

	
}
