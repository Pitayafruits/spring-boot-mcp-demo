package com.example.service;

import com.example.entity.Book;

import java.util.List;

public interface BookService {

  // 根据书名模糊查询
  List<Book> findBooksByTitle(String title);

  // 根据作者查询
  List<Book> findBooksByAuthor(String author);

  // 根据分类查询
  List<Book> findBooksByCategory(String category);
}
