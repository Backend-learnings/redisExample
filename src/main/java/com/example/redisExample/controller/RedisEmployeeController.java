package com.example.redisExample.controller;

import com.example.redisExample.entity.RedisEmployee;
import com.example.redisExample.service.RedisEmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redisEmployee")
public class RedisEmployeeController {

  @Autowired
  RedisEmployeeServiceImpl redisEmployeeService;

  @GetMapping
  public Iterable<RedisEmployee> getAllRedisEmployees() {
    return redisEmployeeService.getAllRedisEmployees();
  }

  @GetMapping("/{id}")
  public RedisEmployee getRedisEmployeeById(@PathVariable("id") int id) {
    return redisEmployeeService.findRedisEmployeeById(id);
  }

  @PostMapping
  public RedisEmployee addRedisEmployee(@RequestBody RedisEmployee redisEmployee) {
    return redisEmployeeService.addRedisEmployee(redisEmployee);
  }

  @DeleteMapping("/{id}")
  public String deleteRedisEmployeeById(@PathVariable("id") int id) {
    return redisEmployeeService.deleteRedisEmployee(id);
  }
}
