package cn.acqz.chatgpt.data.domain.weixin.service.message.engine.impl;

import cn.acqz.chatgpt.data.domain.weixin.model.entity.MessageTextEntity;
import cn.acqz.chatgpt.data.domain.weixin.model.entity.UserBehaviorMessageEntity;
import cn.acqz.chatgpt.data.domain.weixin.service.message.engine.EnginBase;
import cn.acqz.chatgpt.data.domain.weixin.service.message.filter.LogicFilter;
import cn.acqz.chatgpt.data.types.sdk.weixin.XmlUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author qz
 * @description 消息处理
 * @date 2024/4/19
 */
@Service("msgEngineHandle")
public class MsgEngineHandle extends EnginBase {
    @Value("${wx.config.originalid:gh_95b2229b90fb}")
    private String originalId;

    @Override
    public String process(UserBehaviorMessageEntity userBehaviorMessageEntity) {
        LogicFilter router = super.router(userBehaviorMessageEntity);
        if (null == router) {
            return null;
        }

        String resultStr = router.filter(userBehaviorMessageEntity);
        if (StrUtil.isBlank(resultStr)){
            return "";
        }

        //反馈信息[文本]
        MessageTextEntity res = new MessageTextEntity();
        res.setToUserName(userBehaviorMessageEntity.getOpenId());
        res.setFromUserName(originalId);
        res.setCreateTime(String.valueOf(System.currentTimeMillis() / 1000L));
        res.setMsgType("text");
        res.setContent(resultStr);
        return XmlUtil.beanToXml(res);
    }
}
