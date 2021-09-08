package spring.rest.service;


import spring.rest.entity.User;

import java.util.List;

public interface UserService {
    public String findNameById(Long id);
    public List<User> findAll();
    public List<User> findAllWithPosts();
}
