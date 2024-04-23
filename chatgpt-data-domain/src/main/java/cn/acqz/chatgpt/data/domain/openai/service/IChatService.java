package cn.acqz.chatgpt.data.domain.openai.service;

import cn.acqz.chatgpt.data.domain.openai.model.aggregates.ChatProcessAggregate;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

/**
 * @author qz
 * @description OpenAi 应答请求
 * @date 2023-07-22 20:53
 */
public interface IChatService {

    ResponseBodyEmitter completions(ResponseBodyEmitter emitter, ChatProcessAggregate chatProcess);

}
