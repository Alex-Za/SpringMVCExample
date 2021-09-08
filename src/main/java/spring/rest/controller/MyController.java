package spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.rest.entity.Singer;
import spring.rest.entity.User;
import spring.rest.service.SingerService;
import spring.rest.service.UserService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class MyController {

    @Autowired
    private UserService userService;
    @Autowired
    private SingerService singerService;


    @RequestMapping("delete-singer")
    public String deleteSinger() {
        String resultMessage = "";
        Singer singer = singerService.findById(6L);
        if (singer != null) {
            singerService.delete(singer);
            resultMessage = "Singer was deleted";
        }
        return resultMessage;
    }

    @RequestMapping("add-singer")
    public Singer addSinger() {
        Singer singer = new Singer();
        singer.setBirthDate(new Date());
        singer.setFirstName("Sergey");
        singer.setLastName("Kovalchuk");
        singer.setVersion(1);
        Singer resultSinger = singerService.save(singer);
        System.out.println(resultSinger);
        return resultSinger;
    }


    @RequestMapping("all-singers")
    public List<Singer> getAllSingers() {
        List<Singer> allSingers = singerService.findAll();
        return allSingers;
    }

    @RequestMapping("find-name")
    public String findUserNameByIdTest() {
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
