package fbk.cjd.demo.cloud.eurekaclient.controller;

import fbk.cjd.demo.cloud.eurekaclient.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenjd
 * @date 2020/10/10 10:24
 */
@RestController
@RequestMapping("/test")
public class DemoController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/restRibbon")
    public String restRibbon(){
        return "restRibbon:"+port;
    }

    @GetMapping("/feign/{userId}")
    @ResponseBody
    public User feign(@PathVariable Integer userId, String userName){
        User user = new User();
        user.setPort(port);
        user.setUserId(userId);
        user.setUserName(userName);
        return user;
    }

}
