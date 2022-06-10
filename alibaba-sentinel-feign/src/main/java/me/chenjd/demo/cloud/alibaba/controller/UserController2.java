package me.chenjd.demo.cloud.alibaba.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenjd
 * @date 2022/6/10 9:37
 */
@RequestMapping("/user2")
@RestController
@Slf4j
public class UserController2 {

    private static final String RESOURCE_NAME ="user2";

    /**
     * 使用@SentinelResource进行Sentinel流控
     * SentinelResource注解改善接口钟资源定义和被流控降级后的处理方法
     * 使用方法：1、添加依赖
     *           2、配置bean-SentinelResourceAspect
     *  value:定义流控资源
     *  blockHandler：设置流控降级后的处理方法（默认该方法必须声明在同一个类）
     *      如果不想在同一个类中，可以使用 blockHandlerClass 指定，但是方法必须是static
     *  fallback：当接口出现异常，就可以交给fallback指定的方法进行处理
     *      如果不想在同一个类中，可以使用 fallbackClass 指定，但是方法必须是static
     *
     *  注意：如果blockHandler和fallback方法同时指定了，则blockHandler优先级更高
     */
    @GetMapping
    @SentinelResource(value = RESOURCE_NAME,blockHandler = "blockHandlerForUserTest",fallback = "fallbackForUserTest")
    public String userTest(){
        return "user2 normal";
    }

    @GetMapping("{userId}")
    @SentinelResource(value = RESOURCE_NAME,entryType = EntryType.IN,blockHandler = "blockHandlerForDegrade")
    public String userTest(@PathVariable("userId")String userId){
        return "user2 normal:"+userId;
    }

    /**
     * userTest流控降级后的处理方法
     * 注意：
     * 1、一定要是public
     * 2、返回值一定要和源方法（userTest）保证一致，包含源方法的参数
     * 3、可以在参数最后添加BlockException，可以区分是什么规则的处理方法
     */
    public String blockHandlerForUserTest(BlockException ex){
        log.error("",ex);
        return "user2 abnormal blocked";
    }

    /**
     * userTest异常后的处理方法
     * 注意：
     * 1、一定要是public
     * 2、返回值一定要和源方法（userTest）保证一致，包含源方法的参数
     * 3、可以在参数最后添加Throwable，可以区分是什么异常
     */
    public String fallbackForUserTest(Throwable e){
        log.error("",e);
        return "user2 abnormal error";
    }

    /**
     * degrade服务降级的处理方法
    */
    public String blockHandlerForDegrade(String userId,BlockException ex){
        log.error("",ex);
        return "user2 abnormal degrade:"+userId;
    }

    @PostConstruct
    private static void initFlowRules(){
        //流控规则
        List<FlowRule> rules = new ArrayList<>();
        //流控
        FlowRule rule = new FlowRule();
        //设置受保护的资源
        rule.setResource(RESOURCE_NAME);
        // 设置流控规则 QPS
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //设置受保护资源的阈值
        // Set limit QPS to 20.
        rule.setCount(1);
        rules.add(rule);
        //加载配置好的规则
        FlowRuleManager.loadRules(rules);

        //降级规则
        List<DegradeRule> DegradeRules = new ArrayList<>();
        //流控
        DegradeRule degradeRule = new DegradeRule();
        //设置受保护的资源
        degradeRule.setResource(RESOURCE_NAME);
        // 设置规则测率： 异常数
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        //设置异常数
        degradeRule.setCount(2);
        degradeRule.setTimeWindow(10);//10秒内发生的异常
        degradeRule.setMinRequestAmount(2);//最小请求数

        DegradeRules.add(degradeRule);
        //加载配置好的规则
        DegradeRuleManager.loadRules(DegradeRules);
    }

}
