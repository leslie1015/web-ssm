package com.silk.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.silk.auth.dao")
public class AuthServerJwtApplication {

  public static void main(String[] args) {
    SpringApplication.run(AuthServerJwtApplication.class, args);
  }

}
