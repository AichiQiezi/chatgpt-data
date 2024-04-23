package cn.acqz.chatgpt.data.domain.weixin.repository;

import cn.acqz.lottery.rpc.activity.booth.req.DrawReq;
import cn.acqz.lottery.rpc.activity.booth.res.DrawRes;

/**
 * @author qz
 * @description 微信服务仓储
 * @date 2023-11-05 15:34
 */
public interface IWeiXinRepository {

    String genCode(String openId);

    DrawRes doDraw(DrawReq drawReq);

}
