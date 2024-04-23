package cn.acqz.chatgpt.data.domain.weixin.service.message.filter.impl;

import cn.acqz.chatgpt.data.domain.weixin.model.entity.UserBehaviorMessageEntity;
import cn.acqz.chatgpt.data.domain.weixin.service.message.filter.LogicFilter;
import org.springframework.stereotype.Service;

/**
 * @description: 关注微信公众号
 */
@Service("subscribe")
public class SubscribeFilter implements LogicFilter {

    @Override
    public String filter(UserBehaviorMessageEntity userBehaviorMessageEntity) {
        return "感谢关注，快来回复抽奖，参与活动吧！";
    }

}
