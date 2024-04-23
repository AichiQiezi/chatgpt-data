package cn.acqz.chatgpt.data.infrastructure.repository;

import cn.acqz.chatgpt.data.domain.auth.repository.IAuthRepository;
import cn.acqz.chatgpt.data.infrastructure.redis.IRedisService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author qz
 * @description 认证仓储服务
 * @date 2023-11-05 15:53
 */
@Repository
public class AuthRepository implements IAuthRepository {

    private static final String Key = "weixin_code";

    @Resource
    private IRedisService redisService;

    @Override
    public String getCodeUserOpenId(String code) {
        return redisService.getValue(Key + "_" + code);
    }

    @Override
    public void removeCodeByOpenId(String code, String openId) {
        redisService.remove(Key + "_" + code);
        redisService.remove(Key + "_" + openId);
    }

}
