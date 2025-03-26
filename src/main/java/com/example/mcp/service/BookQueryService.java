package com.example.mcp.service;


import com.example.entity.Book;
import com.example.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

/**
 * 图书查询服务，将查询方法作为函数Bean导出
 */
@Service
public class BookQueryService {

  @Resource
  private BookService bookService;

  /**
   * 根据书名查询图书的函数Bean
   */
  @Bean
  public Function<String, List<Book>> findBooksByTitle() {
    return title -> bookService.findBooksByTitle(title);
  }

  /**
   * 根据作者查询图书的函数Bean
   */
  @Bean
  public Function<String, List<Book>> findBooksByAuthor() {
    return author -> bookService.findBooksByAuthor(author);
  }

  /**
   * 根据分类查询图书的函数Bean
   */
  @Bean
  public Function<String, List<Book>> findBooksByCategory() {
    return category -> bookService.findBooksByCategory(category);
  }

}
