package com.example.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ProxyConfig {

  // 代理设置
  private final String PROXY_HOST = "127.0.0.1";
  private final int PROXY_PORT = 10080;

  @PostConstruct
  public void setSystemProxy() {
    // 设置系统代理属性，这会影响Spring Boot自动配置的HTTP客户端
    System.setProperty("http.proxyHost", PROXY_HOST);
    System.setProperty("http.proxyPort", String.valueOf(PROXY_PORT));
    System.setProperty("https.proxyHost", PROXY_HOST);
    System.setProperty("https.proxyPort", String.valueOf(PROXY_PORT));

    System.out.println("System proxy configured: http://" + PROXY_HOST + ":" + PROXY_PORT);
  }
}
