package spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.rest.entity.User;
import spring.rest.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/")
public class MyController {

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String getTest() {
        String userName = userService.findNameById(2L);
        return userName;
    }

    @RequestMapping("all")
    public List<User> getAllUsers() {
        List<User> allUsers = userService.findAll();
        return allUsers;
    }

    @RequestMapping("all-user-with-posts")
    public List<User> getAllUsersWithPosts() {
        List<User> allUserWithPosts = userService.findAllWithPosts();
        return allUserWithPosts;
    }
}
