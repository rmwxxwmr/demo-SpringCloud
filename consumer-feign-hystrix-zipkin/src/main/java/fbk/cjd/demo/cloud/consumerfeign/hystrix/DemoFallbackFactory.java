package fbk.cjd.demo.cloud.consumerfeign.hystrix;

import fbk.cjd.demo.cloud.consumerfeign.entity.User;
import fbk.cjd.demo.cloud.consumerfeign.feign.DemoFeignClients;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author chenjd
 * @date 2020/10/10 15:55
 */
@Component
public class DemoFallbackFactory implements FallbackFactory<DemoFeignClients> {

    @Override
    public DemoFeignClients create(Throwable cause) {
        return (userId, userName) -> {
            User user = new User();
            user.setErrorMsg(cause.getMessage());
            return user;
        };
    }
}
