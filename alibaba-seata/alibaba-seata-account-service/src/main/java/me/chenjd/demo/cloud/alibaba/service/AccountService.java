package me.chenjd.demo.cloud.alibaba.service;

import me.chenjd.demo.cloud.alibaba.entity.Account;
import me.chenjd.demo.cloud.alibaba.mapper.AccountMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenjd
 * @date 2022/6/10 23:01
 */
@Service
public class AccountService {

    private final AccountMapper accountMapper;

    public AccountService(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    /**
     * 减库存
     */
    @Transactional
    public void buy(Integer userId,Integer money) {
        Account account = accountMapper.selectById(userId);
        int finalMoney = account.getMoney() - money;
        if(finalMoney>=0){
            account.setMoney(finalMoney);
            accountMapper.updateById(account);
        }
        else {
            throw new RuntimeException("账户余额不足!");
        }
    }
}
