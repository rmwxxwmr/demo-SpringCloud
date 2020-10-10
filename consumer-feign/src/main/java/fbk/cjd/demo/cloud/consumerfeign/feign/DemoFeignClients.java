package fbk.cjd.demo.cloud.consumerfeign.feign;

import fbk.cjd.demo.cloud.consumerfeign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenjd
 * @date 2020/10/10 13:53
 */
@FeignClient("provider")
public interface DemoFeignClients {

    @GetMapping("/test/feign/{userId}")
    @ResponseBody
    User test(@PathVariable Integer userId, @RequestParam("userName") String userName);

}
