package cn.acqz.chatgpt.data.domain.weixin.service.message.filter.impl;

import cn.acqz.chatgpt.data.domain.weixin.model.entity.MessageTextEntity;
import cn.acqz.chatgpt.data.domain.weixin.model.entity.UserBehaviorMessageEntity;
import cn.acqz.chatgpt.data.domain.weixin.repository.IWeiXinRepository;
import cn.acqz.chatgpt.data.domain.weixin.service.message.filter.TextLogicFilter;
import cn.acqz.chatgpt.data.types.sdk.weixin.XmlUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 使用验证码进行登录
 */
@Service
public class CaptchaLogicFilter extends TextLogicFilter {

    @Resource
    private IWeiXinRepository weiXinRepository;

    @Override
    public String filter(UserBehaviorMessageEntity userBehaviorMessageEntity) {
        String genCode = weiXinRepository.genCode(userBehaviorMessageEntity.getOpenId());
        return String.format("您的验证码为：%s 有效期%d分钟！", genCode, 3);
    }

}
