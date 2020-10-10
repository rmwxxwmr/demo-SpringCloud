package fbk.cjd.demo.cloud.consumerfeign.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjd
 * @date 2020/10/10 13:47
 */
@RestController
@RequestMapping
public class FeignController {

    @GetMapping
    public String test(){
        return "";
    }

}
