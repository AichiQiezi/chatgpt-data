package cn.acqz.chatgpt.data.domain.weixin.service;

import cn.acqz.chatgpt.data.domain.weixin.model.entity.UserBehaviorMessageEntity;

/**
 * @author qz
 * @description 受理用户行为接口
 * @date 2023-08-05 17:04
 */
public interface IWeiXinBehaviorService {

    String acceptUserBehavior(UserBehaviorMessageEntity userBehaviorMessageEntity);

}
