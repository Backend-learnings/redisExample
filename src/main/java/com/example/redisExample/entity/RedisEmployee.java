package com.example.redisExample.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("redisEmployee")
public class RedisEmployee {

  @Id
  private int id;
  private String name;
  private int age;
}
