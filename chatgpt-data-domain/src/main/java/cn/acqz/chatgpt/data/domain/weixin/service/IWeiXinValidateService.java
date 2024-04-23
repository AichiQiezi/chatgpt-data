package cn.acqz.chatgpt.data.domain.weixin.service;

/**
 * @author qz
 * @description 验签接口
 * @date 2023-08-05 16:56
 */
public interface IWeiXinValidateService {

    boolean checkSign(String signature, String timestamp, String nonce);

}
