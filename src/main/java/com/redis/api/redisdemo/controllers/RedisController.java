package com.redis.api.redisdemo.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.api.redisdemo.dao.UserDao;
import com.redis.api.redisdemo.models.User;

@RestController
@RequestMapping("/users")
public class RedisController {

    @Autowired
    private UserDao userDao;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        user.setId(UUID.randomUUID().toString());
        return userDao.saveUser(user);
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable String id) {
        return userDao.findUser(id);
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable String id) {
        return userDao.deleteUser(id);
    }

    @PostMapping("/updateUser")
    public User updateUser(@RequestBody User user) {
        userDao.updateUser(user);
        return user;
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        Map<Object, Object> all = userDao.findAllUsers();
        Collection<Object> values = all.values();
        List<User> users = values.stream().map(value -> (User) value).toList();
        return users;
    }
}
