package cn.acqz.chatgpt.data.domain.weixin.service.message.engine;

import cn.acqz.chatgpt.data.domain.weixin.model.entity.UserBehaviorMessageEntity;
import cn.acqz.chatgpt.data.domain.weixin.service.message.filter.LogicFilter;

import java.util.Map;

/**
 * @author qz
 * @description
 * @date 2024/4/19
 */
public abstract class EnginBase extends EngineConfig implements Engine{

    /**
     * 根据消息类型路由
     *
     * @param userBehaviorMessageEntity 消息内容
     * @return 返回消息处理器
     */
    protected LogicFilter router(UserBehaviorMessageEntity userBehaviorMessageEntity) {

        Map<String, LogicFilter> logicGroup = logicFilterMaps.get(userBehaviorMessageEntity.getMsgType());

        // 事件处理
        if ("event".equalsIgnoreCase(userBehaviorMessageEntity.getMsgType())) {
            return logicGroup.get(userBehaviorMessageEntity.getEvent());
        }

        // 内容处理
        if ("text".equalsIgnoreCase(userBehaviorMessageEntity.getMsgType())) {
            System.out.println(userBehaviorMessageEntity.getContent());
            switch (userBehaviorMessageEntity.getContent()){
                case "抽奖":
                    return logicGroup.get("lottery");
                case "验证码":
                    return logicGroup.get("captcha");
                default:
                    return logicGroup.get("default");
            }
        }
        return null;
    }
}
