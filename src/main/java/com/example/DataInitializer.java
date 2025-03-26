package com.example;


import com.example.entity.Book;
import com.example.repository.BookRepository;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer  implements CommandLineRunner {

  @Resource
  private BookRepository bookRepository;

  @Override
  public void run(String... args) throws Exception {
    // 准备示例数据
    List<Book> sampleBooks = Arrays.asList(
            new Book(null, "Spring实战（第6版）", "编程", "Craig Walls",
                    LocalDate.of(2022, 1, 15), "9787115582247"),
            new Book(null, "深入理解Java虚拟机", "编程", "周志明",
                    LocalDate.of(2019, 12, 1), "9787111641247"),
            new Book(null, "Java编程思想（第4版）", "编程", "Bruce Eckel",
                    LocalDate.of(2007, 6, 1), "9787111213826"),
            new Book(null, "算法（第4版）", "计算机科学", "Robert Sedgewick",
                    LocalDate.of(2012, 10, 1), "9787115293800"),
            new Book(null, "云原生架构", "架构设计", "张三",
                    LocalDate.of(2023, 3, 15), "9781234567890"),
            new Book(null, "微服务设计模式", "架构设计", "张三",
                    LocalDate.of(2021, 8, 20), "9789876543210"),
            new Book(null, "领域驱动设计", "架构设计", "Eric Evans",
                    LocalDate.of(2010, 4, 10), "9787111214748"),
            new Book(null, "高性能MySQL", "数据库", "Baron Schwartz",
                    LocalDate.of(2013, 5, 25), "9787111464747"),
            new Book(null, "Redis实战", "数据库", "Josiah L. Carlson",
                    LocalDate.of(2015, 9, 30), "9787115419378"),
            new Book(null, "深入浅出Docker", "容器技术", "李四",
                    LocalDate.of(2022, 11, 20), "9787123456789")
    );

    // 保存示例数据
    bookRepository.saveAll(sampleBooks);

    System.out.println("数据初始化完成，共加载 " + sampleBooks.size() + " 本图书");
  }

}
