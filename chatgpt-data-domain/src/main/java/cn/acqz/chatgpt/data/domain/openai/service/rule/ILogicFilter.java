package cn.acqz.chatgpt.data.domain.openai.service.rule;

import cn.acqz.chatgpt.data.domain.openai.model.aggregates.ChatProcessAggregate;
import cn.acqz.chatgpt.data.domain.openai.model.entity.RuleLogicEntity;

/**
 * @author qz
 * @description 规则过滤接口
 * @date 2023-09-16 16:59
 */
public interface ILogicFilter<T> {

    RuleLogicEntity<ChatProcessAggregate> filter(ChatProcessAggregate chatProcess, T data) throws Exception;

}
