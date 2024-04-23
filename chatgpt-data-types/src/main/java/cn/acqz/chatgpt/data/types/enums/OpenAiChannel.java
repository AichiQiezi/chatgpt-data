package cn.acqz.chatgpt.data.types.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author qz
 * @description OpenAi 渠道
 * @date 2023-10-15 14:01
 */
@Getter
@AllArgsConstructor
public enum OpenAiChannel {

    ChatGLM("ChatGLM"),
    ChatGPT("ChatGPT"),

    ;
    private final String code;

    public static OpenAiChannel getChannel(String model) {
        if (model.toLowerCase().contains("gpt") || model.toLowerCase().contains("dall")) return OpenAiChannel.ChatGPT;
        if (model.toLowerCase().contains("glm")) return OpenAiChannel.ChatGLM;
        return null;
    }

}
