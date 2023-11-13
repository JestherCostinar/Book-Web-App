package com.jes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jes.model.Book;
import com.jes.service.BookService;

@RestController
@ResponseBody
@RequestMapping("/books")
public class HomeController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> books() {
        return bookService.getAllBooks();
    }
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public void addBook(@RequestBody Book book) {
		bookService.createBook(book);
	}
}
