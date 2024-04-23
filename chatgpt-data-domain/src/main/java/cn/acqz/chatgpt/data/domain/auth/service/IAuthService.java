package cn.acqz.chatgpt.data.domain.auth.service;

import cn.acqz.chatgpt.data.domain.auth.model.entity.AuthStateEntity;

/**
 * @author qz
 * @description 鉴权验证服务接口
 * @date 2023-08-05 18:22
 */
public interface IAuthService {

    /**
     * 登录验证
     * @param code 验证码
     * @return Token
     */
    AuthStateEntity doLogin(String code);

    boolean checkToken(String token);

    String openid(String token);

}
