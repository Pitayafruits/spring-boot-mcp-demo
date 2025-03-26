package com.example.repository;



import com.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  // 根据书名模糊查询
  @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))")
  List<Book> findByTitleContaining(@Param("title") String title);

  // 根据作者查询
  List<Book> findByAuthor(String author);

  // 根据分类查询
  List<Book> findByCategory(String category);

}
