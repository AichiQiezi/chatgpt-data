package cn.acqz.chatgpt.data.domain.openai.model.aggregates;

import cn.acqz.chatgpt.data.domain.openai.model.entity.MessageEntity;
import cn.acqz.chatgpt.data.domain.openai.model.valobj.GenerativeModelVO;
import cn.acqz.chatgpt.data.types.common.Constants;
import cn.acqz.chatgpt.data.types.enums.ChatGPTModel;
import cn.acqz.chatgpt.data.types.enums.OpenAiChannel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author qz
 * @description 对话聚合对象
 * @date 2023-07-22 21:09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatProcessAggregate {

    /** 用户ID */
    private String openid;
    /** 默认模型 */
    private String model = ChatGPTModel.GPT_3_5_TURBO.getCode();
    /** 问题描述 */
    private List<MessageEntity> messages;

    public boolean isWhiteList(String whiteListStr) {
        String[] whiteList = whiteListStr.split(Constants.SPLIT);
        for (String whiteOpenid : whiteList) {
            if (whiteOpenid.equals(openid)) return true;
        }
        return false;
    }

    public OpenAiChannel getChannel(){
        return OpenAiChannel.getChannel(this.model);
    }

    public GenerativeModelVO getGenerativeModelVO() {
        switch (this.model) {
            case "dall-e-2":
            case "dall-e-3":
                return GenerativeModelVO.IMAGES;
            default:
                return GenerativeModelVO.TEXT;
        }
    }

}
