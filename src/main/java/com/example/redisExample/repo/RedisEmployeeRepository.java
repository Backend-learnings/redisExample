package com.example.redisExample.repo;

import com.example.redisExample.entity.RedisEmployee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisEmployeeRepository extends CrudRepository<RedisEmployee, Integer> {
}
