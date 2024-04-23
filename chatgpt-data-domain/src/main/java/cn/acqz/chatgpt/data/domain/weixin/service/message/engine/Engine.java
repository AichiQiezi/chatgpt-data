package cn.acqz.chatgpt.data.domain.weixin.service.message.engine;

import cn.acqz.chatgpt.data.domain.weixin.model.entity.UserBehaviorMessageEntity;

/**
 * @author qz
 * @description 策略执行引擎
 * @date 2024/4/19
 */
public interface Engine {
    /**
     * 过滤器
     * @param userBehaviorMessageEntity       入参
     * @return              出参
     * @throws Exception    异常
     */
    String process(final UserBehaviorMessageEntity userBehaviorMessageEntity);

}
