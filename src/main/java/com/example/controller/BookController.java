package com.example.controller;

import com.example.entity.Book;
import com.example.service.BookService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

  @Resource
  private BookService bookService;

  @GetMapping("/search/title")
  public ResponseEntity<List<Book>> searchBooksByTitle(@RequestParam String title) {
    List<Book> books = bookService.findBooksByTitle(title);
    return ResponseEntity.ok(books);
  }

  @GetMapping("/search/author")
  public ResponseEntity<List<Book>> searchBooksByAuthor(@RequestParam String author) {
    List<Book> books = bookService.findBooksByAuthor(author);
    return ResponseEntity.ok(books);
  }

  @GetMapping("/search/category")
  public ResponseEntity<List<Book>> searchBooksByCategory(@RequestParam String category) {
    List<Book> books = bookService.findBooksByCategory(category);
    return ResponseEntity.ok(books);
  }
}
