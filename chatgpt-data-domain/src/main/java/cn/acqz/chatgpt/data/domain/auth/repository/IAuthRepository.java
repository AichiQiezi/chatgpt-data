package cn.acqz.chatgpt.data.domain.auth.repository;

/**
 * @author qz
 * @description 认证仓储服务
 * @date 2023-11-05 15:52
 */
public interface IAuthRepository {

    String getCodeUserOpenId(String code);

    void removeCodeByOpenId(String code, String openId);

//    void crea

}
