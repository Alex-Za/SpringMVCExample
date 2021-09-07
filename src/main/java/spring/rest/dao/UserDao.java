package spring.rest.dao;

import spring.rest.entity.Post;
import spring.rest.entity.User;

import java.util.List;

public interface UserDao {
    String findNameById(Long id);
    List<User> findAll();
    List<User> findAllWithPosts();
}
