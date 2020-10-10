package fbk.cjd.demo.cloud.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
