package cn.acqz.chatgpt.data.domain.openai.service.channel;

import cn.acqz.chatgpt.data.domain.openai.model.aggregates.ChatProcessAggregate;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

/**
 * @author qz
 * @description 服务组
 * @date 2023-10-15 14:11
 */
public interface OpenAiGroupService {

    void doMessageResponse(ChatProcessAggregate chatProcess, ResponseBodyEmitter emitter) throws Exception;

}
