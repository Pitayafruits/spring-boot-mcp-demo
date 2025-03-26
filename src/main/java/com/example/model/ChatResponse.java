package com.example.model;

import lombok.Data;

/**
 * 聊天响应模型，包含AI返回的内容
 */
@Data
public class ChatResponse {

  private String content;

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public ChatResponse() {
  }

  public ChatResponse(String content) {
    this.content = content;
  }

}
