package com.hazelcast.springboot.caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{isbn}")
    public String getBookNameByIsbn(@PathVariable("isbn") String isbn) {
    	System.out.println("Method:: getBookNameByIsbn");
        return bookService.getBookNameByIsbn(isbn);
    }
    
    @PostMapping(path="/{isbn}"/*, consumes = "application/text", produces = "application/text"*/)
    public String postBookNameByIsbn(@PathVariable("isbn") String isbn, @RequestBody String data) {
    	System.out.println("Method::postBookNameByIsbn");
        return bookService.postBookNameByIsbn(data, isbn);
    }
}

