package cn.acqz.chatgpt.data.domain.weixin.service.message.filter.impl;

import cn.acqz.chatgpt.data.domain.weixin.model.entity.UserBehaviorMessageEntity;
import cn.acqz.chatgpt.data.domain.weixin.service.message.filter.LogicFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @description: 取消关注微信公众号
 */
@Service("unsubscribe")
public class UnsubscribeFilter implements LogicFilter {

    private Logger logger = LoggerFactory.getLogger(UnsubscribeFilter.class);

    @Override
    public String filter(UserBehaviorMessageEntity userBehaviorMessageEntity) {
        logger.info("用户{}已取消关注", userBehaviorMessageEntity.getOpenId());
        return null;
    }

}
