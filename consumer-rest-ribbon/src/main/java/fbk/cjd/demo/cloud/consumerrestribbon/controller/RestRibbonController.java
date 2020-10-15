package fbk.cjd.demo.cloud.consumerrestribbon.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenjd
 * @date 2020/10/10 10:40
 */
@RestController
@RequestMapping
public class RestRibbonController {

    private final RestTemplate restTemplate;

    public RestRibbonController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String test(){
        ResponseEntity<String> entity = restTemplate.getForEntity("http://provider-sleuth-zipkin-cluster/test/restRibbon", String.class);
        return entity.getBody();
    }

}
