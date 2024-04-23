package cn.acqz.chatgpt.data.domain.openai.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author qz
 * @description 模型生成类型
 * @date 2023-11-25 14:09
 */
@Getter
@AllArgsConstructor
public enum GenerativeModelVO {

    TEXT("TEXT","文本"),
    IMAGES("IMAGES","图片"),
    ;

    private final String code;
    private final String info;

}
