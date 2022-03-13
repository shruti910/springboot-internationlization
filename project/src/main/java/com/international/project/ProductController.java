package com.international.project;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ResourceBundleMessageSource source;
	
	
	@GetMapping("/product")
	public ResponseEntity<ProductDto> getLocaleProductMessage(
			@RequestHeader(name = "Accept-Language", required = false) final Locale locale,
			@RequestParam(name = "username", defaultValue = "Shruti", required = false) final String username) {
		log.info("Returning greetings for locale = {}", locale);
		ProductDto dto = new ProductDto(
				resolveMessage(MessageConstants.greetings, new Object[]{username}, locale),
				resolveMessage(MessageConstants.title,null,locale),
				resolveMessage(MessageConstants.productName,null,locale),
				resolveMessage(MessageConstants.productPrice,null,locale),
				resolveMessage(MessageConstants.productLastupdated,null,locale),
				resolveMessage(MessageConstants.chooseLang,null,locale)
				);
		
		return ResponseEntity.ok().body(dto);
	}
	
	public String resolveMessage(String key, Object[] args, Locale locale) {
		return source.getMessage(key, args, locale);
	}

}
