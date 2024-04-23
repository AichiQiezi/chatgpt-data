package cn.acqz.chatgpt.data.domain.openai.service.channel.impl;

import cn.acqz.chatgpt.data.domain.openai.service.channel.OpenAiGroupService;
import cn.acqz.chatgpt.data.domain.openai.model.aggregates.ChatProcessAggregate;
import cn.acqz.chatgpt.data.domain.openai.model.valobj.GenerativeModelVO;
import cn.acqz.chatgpt.data.domain.openai.service.channel.model.IGenerativeModelService;
import cn.acqz.chatgpt.data.domain.openai.service.channel.model.impl.ImageGenerativeModelServiceImpl;
import cn.acqz.chatgpt.data.domain.openai.service.channel.model.impl.TextGenerativeModelServiceImpl;
import cn.acqz.chatgpt.session.OpenAiSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qz
 * @description ChatGPT 服务
 * @date 2023-10-15 14:11
 */
@Service
public class ChatGPTService implements OpenAiGroupService {

    @Autowired(required = false)
    protected OpenAiSession chatGPTOpenAiSession;

    private final Map<GenerativeModelVO, IGenerativeModelService> generativeModelGroup = new HashMap<>();

    public ChatGPTService(ImageGenerativeModelServiceImpl imageGenerativeModelService, TextGenerativeModelServiceImpl textGenerativeModelService) {
        generativeModelGroup.put(GenerativeModelVO.IMAGES, imageGenerativeModelService);
        generativeModelGroup.put(GenerativeModelVO.TEXT, textGenerativeModelService);
    }

    @Override
    public void doMessageResponse(ChatProcessAggregate chatProcess, ResponseBodyEmitter emitter) throws Exception {
        GenerativeModelVO generativeModelVO = chatProcess.getGenerativeModelVO();
        generativeModelGroup.get(generativeModelVO).doMessageResponse(chatProcess, emitter);
    }

}
