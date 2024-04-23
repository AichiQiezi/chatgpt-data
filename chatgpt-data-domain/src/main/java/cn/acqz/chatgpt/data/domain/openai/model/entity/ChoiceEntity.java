package cn.acqz.chatgpt.data.domain.openai.model.entity;

import lombok.Data;

/**
 * @author qz
 * @description
 * @date 2023-07-16 08:47
 */
@Data
public class ChoiceEntity {

    /** stream = true 请求参数里返回的属性是 delta */
    private MessageEntity delta;
    /** stream = false 请求参数里返回的属性是 delta */
    private MessageEntity message;

}
