package cn.acqz.chatgpt.data.domain.weixin.service.message.filter;

import cn.acqz.chatgpt.data.domain.weixin.model.entity.UserBehaviorMessageEntity;

/**
 * @author qz
 * @description 逻辑过滤器
 * @date 2024/4/19
 */
public interface LogicFilter {
    String filter(UserBehaviorMessageEntity userBehaviorMessageEntity);

}
