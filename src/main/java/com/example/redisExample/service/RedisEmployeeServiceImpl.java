package com.example.redisExample.service;

import com.example.redisExample.entity.RedisEmployee;
import com.example.redisExample.repo.RedisEmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@EnableCaching
public class RedisEmployeeServiceImpl {

  @Autowired
  RedisEmployeeRepository redisEmployeeRepository;

  public Iterable<RedisEmployee> getAllRedisEmployees() {
    return redisEmployeeRepository.findAll();
  }

  public String deleteRedisEmployee(int id) {
    try {
      redisEmployeeRepository.deleteById(id);
    } catch (Exception e) {
      log.info("Some problem while deleting the Redis Employee : {}"+ e);
    }
    return "Redis Employee Deleted Successfully!";
  }

  @Cacheable
  public RedisEmployee findRedisEmployeeById(int id) {
    Optional<RedisEmployee> option = redisEmployeeRepository.findById(id);
    return option.isPresent() ? option.get() : null;
  }

  public RedisEmployee addRedisEmployee(RedisEmployee redisEmployee) {
    return redisEmployeeRepository.save(redisEmployee);
  }

}
