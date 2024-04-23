package cn.acqz.chatgpt.data.infrastructure.dao;

import cn.acqz.chatgpt.data.infrastructure.po.UserAccountPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author qz
 * @description 用户账户DAO
 * @date 2023-10-03 16:39
 */
@Mapper
public interface IUserAccountDao {

    int subAccountQuota(String openid);

    UserAccountPO queryUserAccount(String openid);

    void insert(UserAccountPO userAccountPOReq);

    int addAccountQuota(UserAccountPO userAccountPOReq);

}
