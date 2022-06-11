package me.chenjd.demo.cloud.alibaba.controller;

import me.chenjd.demo.cloud.alibaba.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjd
 * @date 2022/6/10 23:01
 */
@RestController
@RequestMapping("account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 减账户金额
     */
    @GetMapping(path = "/buy")
    public String buy(Integer userId,Integer money) {
        accountService.buy(userId, money);
        return "success";
    }

}
