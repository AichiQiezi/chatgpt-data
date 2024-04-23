package cn.acqz.chatgpt.data.domain.openai.service.channel.model;

import cn.acqz.chatgpt.data.domain.openai.model.aggregates.ChatProcessAggregate;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.io.IOException;

/**
 * @author qz
 * @description 模型生成文字/图片接口服务
 * @date 2023-11-25 13:54
 */
public interface IGenerativeModelService {

    void doMessageResponse(ChatProcessAggregate chatProcess, ResponseBodyEmitter emitter) throws IOException;

}
