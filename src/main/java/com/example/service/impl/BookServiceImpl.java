package com.example.service.impl;



import com.example.entity.Book;
import com.example.repository.BookRepository;
import com.example.service.BookService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl  implements BookService {

  @Resource
  private BookRepository bookRepository;


  @Override
  @Tool(name = "findBooksByTitle", description = "根据书名模糊查询图书，支持部分标题匹配")
  public List<Book> findBooksByTitle(@ToolParam(description = "书名关键词") String title) {
    return bookRepository.findByTitleContaining(title);
  }

  @Override
  @Tool(name = "findBooksByAuthor", description = "根据作者精确查询图书")
  public List<Book> findBooksByAuthor(@ToolParam(description = "作者姓名") String author) {
    return bookRepository.findByAuthor(author);
  }

  @Override
  @Tool(name = "findBooksByCategory", description = "根据图书分类精确查询图书")
  public List<Book> findBooksByCategory(@ToolParam(description = "图书分类")String category) {
    return bookRepository.findByCategory(category);
  }
}
