package cn.acqz.chatgpt.data.domain.weixin.service.message.filter.impl;

import cn.acqz.chatgpt.data.domain.weixin.model.entity.UserBehaviorMessageEntity;
import cn.acqz.chatgpt.data.domain.weixin.service.message.filter.TextLogicFilter;
import org.springframework.stereotype.Service;

@Service
public class HelloLogicFilter extends TextLogicFilter {
    @Override
    public String filter(UserBehaviorMessageEntity userBehaviorMessageEntity) {
        return "你是傻逼";
    }
}
