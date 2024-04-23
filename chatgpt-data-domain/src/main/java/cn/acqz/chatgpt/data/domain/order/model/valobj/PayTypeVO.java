package cn.acqz.chatgpt.data.domain.order.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author qz
 * @description 支付类型
 * @date 2023-09-29 08:29
 */
@Getter
@AllArgsConstructor
public enum PayTypeVO {

    WEIXIN_NATIVE(0, "微信Native支付"),
            ;

    private final Integer code;
    private final String desc;

    public static PayTypeVO get(Integer code){
        switch (code){
            case 0:
                return PayTypeVO.WEIXIN_NATIVE;
            default:
                return PayTypeVO.WEIXIN_NATIVE;
        }
    }

}
