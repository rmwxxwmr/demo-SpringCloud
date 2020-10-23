package me.chenjd.demo.cloud.gatewayzuul.filter;

import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;

/**
 * @author chenjd
 * @date 2020/10/12 9:22
 */
@Component
public class DemoZuulFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        //todo
        return null;
    }
}
