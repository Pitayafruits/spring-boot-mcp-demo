package com.example.config;




import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 聊天客户端配置类
 */
@Configuration
public class ChatClientConfig {


  @Autowired
  private ToolCallbackProvider toolCallbackProvider;

  /**
   * 配置ChatClient，注册系统指令和工具函数
   */
  @Bean
  public ChatClient chatClient(ChatClient.Builder builder) {
    return builder
            .defaultSystem("你是一个图书管理助手，可以帮助用户查询图书信息。" +
                    "你可以根据书名模糊查询、根据作者查询和根据分类查询图书。" +
                    "回复时，请使用简洁友好的语言，并将图书信息整理为易读的格式。")
            // 注册工具方法
            .defaultTools(toolCallbackProvider)
            .build();
  }
}
