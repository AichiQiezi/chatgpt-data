package cn.acqz.chatgpt.data.domain.openai.repository;

import cn.acqz.chatgpt.data.domain.openai.model.entity.UserAccountQuotaEntity;

/**
 * @author qz
 * @description OpenAi 仓储接口
 * @date 2023-10-03 16:49
 */
public interface IOpenAiRepository {

    int subAccountQuota(String openai);

    UserAccountQuotaEntity queryUserAccount(String openid);

}
