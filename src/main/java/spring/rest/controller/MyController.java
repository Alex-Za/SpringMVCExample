package spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.rest.entity.*;
import spring.rest.service.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class MyController {

    @Autowired
    private UserService userService;
    @Autowired
    private SingerService singerService;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private SingerSummaryUntype singerSummaryUntype;
    @Autowired
    private SingerSummaryService singerSummaryService;
    @Autowired
    private MelodistService melodistService;

    @RequestMapping("melodists")
    public String list(Model uiModel) {
        List<Melodist> melodists = melodistService.findAll();
        Map<String, List<Melodist>> test = new HashMap<>();
        test.put("melodists", melodists);
        uiModel.addAllAttributes(test);

        return "melodists/list";
    }

//    @RequestMapping("find-album")
//    public List<Album> getAlbumByTitle() {
//        return albumService.findByTitle("hello");
//    }
//
//    @RequestMapping("get-singers")
//    public List<Singer> getSingers() {
//        return singerService.findAll();
//    }

//    @RequestMapping("save-singer")
//    public Singer saveSinger() {
//        Singer singer = new Singer();
//        singer.setFirstName("Anton");
//        singer.setLastName("Pikachu");
//        singer.setBirthDate(new Date());
//        singer.setVersion(0);
//
//        return singerService.save(singer);
//    }

//    @RequestMapping("test")
//    public List<SingerSummary> test() {
//        List<SingerSummary> singerSummaryList = singerSummaryService.findAll();
//        return singerSummaryList;
//    }

//    @RequestMapping("test")
//    public String test() {
//        singerSummaryUntype.displayAllSingerSummary();
//        return "success";
//    }

//    @RequestMapping("delete-singer")
//    public String deleteSinger() {
//        String resultMessage = "";
//        Singer singer = singerService.findById(5L);
//        if (singer != null) {
//            singerService.delete(singer);
//            resultMessage = "Singer was deleted";
//        }
//        return resultMessage;
//    }
//
//    @RequestMapping("add-singer")
//    public Singer addSinger() {
//        Singer singer = new Singer();
//        singer.setBirthDate(new Date());
//        singer.setFirstName("Sergey");
//        singer.setLastName("Kovalchuk");
//        singer.setVersion(1);
//        Singer resultSinger = singerService.save(singer);
//        System.out.println(resultSinger);
//        return resultSinger;
//    }
//
//
//    @RequestMapping("all-singers")
//    public List<Singer> getAllSingers() {
//        List<Singer> allSingers = singerService.findAll();
//        return allSingers;
//    }

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
