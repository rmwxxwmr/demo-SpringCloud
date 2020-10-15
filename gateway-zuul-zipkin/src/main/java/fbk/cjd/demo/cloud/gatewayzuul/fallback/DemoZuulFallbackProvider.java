package fbk.cjd.demo.cloud.gatewayzuul.fallback;


import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author chenjd
 * @date 2020/10/12 9:47
 */
@Component
public class DemoZuulFallbackProvider implements FallbackProvider{

    @Override
    public String getRoute() {
        return "consumer-rest-ribbon";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            @NonNull
            public HttpStatus getStatusCode() {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() {
                return 200;
            }

            @Override
            @NonNull
            public String getStatusText() {
                return "ok";
            }

            @Override
            public void close() {

            }

            @Override
            @NonNull
            public InputStream getBody() {
                return new ByteArrayInputStream(("服务不可用:"+cause.getMessage()).getBytes());
            }

            @Override
            @NonNull
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                return httpHeaders;
            }
        };
    }
}
