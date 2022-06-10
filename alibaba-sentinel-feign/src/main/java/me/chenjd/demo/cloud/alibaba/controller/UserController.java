package me.chenjd.demo.cloud.alibaba.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenjd
 * @date 2022/6/10 9:37
 */
@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {

    private static final String RESOURCE_NAME ="user";

    @GetMapping
    public String getUser(){
        //sentinel针对资源进行限制
        Entry entry=null;
        try{
            entry=SphU.entry(RESOURCE_NAME);
            //被保护的业务逻辑
            return "user normal";
        }
        catch (BlockException e){
            //资源访问阻止，被限流或被降级
            //进行相应的处理操作
            log.error("",e);
            return "user abnormal blocked";
        }
        catch (Exception ee){
            // 若需要配置降级规则，需要通过这种方式记录业务异常
            Tracer.traceEntry(ee,entry);
        }
        finally {
            if(entry!=null){
                entry.exit();
            }
        }
        return null;
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
    }

}
