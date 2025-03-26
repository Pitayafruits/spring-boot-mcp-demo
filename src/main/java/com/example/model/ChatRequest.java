package com.example.model;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * 聊天请求模型，包含用户发送的消息
 */
@Data
public class ChatRequest implements Serializable {

  private String message;

  public void setMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public ChatRequest() {
  }

  public ChatRequest(String message) {
    this.message = message;
  }

}
