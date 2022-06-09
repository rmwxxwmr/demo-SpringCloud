package me.chenjd.demo.cloud.alibaba.controller;

import me.chenjd.demo.cloud.alibaba.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chenjd
 * @date 2022/6/9 13:58
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final List<User> USERS;

    static {
        User user1 = new User().setUserId(1);
        User user2 = new User().setUserId(2);
        User user3 = new User().setUserId(3);
        User user4 = new User().setUserId(4);
        User user5 = new User().setUserId(5);
        User user6 = new User().setUserId(6);
        USERS=List.of(user1, user2, user3, user4, user5, user6);
    }

    @GetMapping
    public List<User> getList(){
        return USERS;
    }

    @GetMapping("{userId}")
    public User get(@PathVariable("userId") Integer userId){
        return USERS.stream().filter(user -> user.getUserId().equals(userId)).findFirst().orElse(null);
    }

}
