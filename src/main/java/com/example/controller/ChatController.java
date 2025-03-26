package com.example.controller;


import com.example.model.ChatRequest;
import com.example.model.ChatResponse;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 聊天控制器，处理AI聊天请求
 */
@RestController
@RequestMapping("/api/chat")
public class ChatController {


  @Resource
  private ChatClient chatClient;


  /**
   * 处理聊天请求，使用AI和MCP工具进行响应
   *
   * @param request 聊天请求
   * @return 包含AI回复的响应
   */
  @PostMapping
  public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request) {
    try {
      // 创建用户消息
      String userMessage = request.getMessage();

      // 使用流式API调用聊天
      String content = chatClient.prompt()
              .user(userMessage)
              .call()
              .content();

      return ResponseEntity.ok(new ChatResponse(content));
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.ok(new ChatResponse("处理请求时出错: " + e.getMessage()));
    }
  }

}
