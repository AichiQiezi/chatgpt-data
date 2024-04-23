package cn.acqz.chatgpt.data.domain.weixin.service.message;

import cn.acqz.chatgpt.data.domain.weixin.model.entity.MessageTextEntity;
import cn.acqz.chatgpt.data.domain.weixin.model.entity.UserBehaviorMessageEntity;
import cn.acqz.chatgpt.data.domain.weixin.model.valobj.MsgTypeVO;
import cn.acqz.chatgpt.data.domain.weixin.service.IWeiXinBehaviorService;
import cn.acqz.chatgpt.data.domain.weixin.repository.IWeiXinRepository;
import cn.acqz.chatgpt.data.domain.weixin.service.message.engine.impl.MsgEngineHandle;
import cn.acqz.chatgpt.data.types.exception.ChatGPTException;
import cn.acqz.chatgpt.data.types.sdk.weixin.XmlUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.cache.Cache;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author qz
 * @description 受理用户行为接口实现类
 * @date 2023-08-05 17:04
 */
@Service
public class WeiXinBehaviorService implements IWeiXinBehaviorService {

    @Resource
    private MsgEngineHandle msgEngineHandle;

    @Override
    public String acceptUserBehavior(UserBehaviorMessageEntity userBehaviorMessageEntity) {
        String processed = msgEngineHandle.process(userBehaviorMessageEntity);
        if (StrUtil.isBlank(processed)){
            throw new ChatGPTException(userBehaviorMessageEntity.getMsgType() + " 未被处理的行为类型 Err！");
        }
        return processed;
    }

}
