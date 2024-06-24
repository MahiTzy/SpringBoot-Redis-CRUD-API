package com.redis.api.redisdemo.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.redis.api.redisdemo.models.User;

@Repository
public class UserDao {
    
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String HASH_KEY = "User";

    public User saveUser(User user) {
        redisTemplate.opsForHash().put(HASH_KEY, user.getId(), user);
        return user;
    }

    public User findUser(String id) {
        return (User) redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    public String deleteUser(String id) {
        redisTemplate.opsForHash().delete(HASH_KEY, id);
        return "User removed !!";
    }

    public void updateUser(User user) {
        saveUser(user);
    }

    public Map<Object, Object> findAllUsers() {
        return redisTemplate.opsForHash().entries(HASH_KEY);
    }
}
