package me.chenjd.demo.cloud.alibaba.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.chenjd.demo.cloud.alibaba.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author chenjd
 * @date 2022/6/10 23:01
 */
@Mapper
@Repository
public interface AccountMapper extends BaseMapper<Account> {

}
