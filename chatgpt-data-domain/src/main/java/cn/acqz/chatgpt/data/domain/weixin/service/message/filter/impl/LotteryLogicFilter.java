package cn.acqz.chatgpt.data.domain.weixin.service.message.filter.impl;

import cn.acqz.chatgpt.data.domain.weixin.model.entity.UserBehaviorMessageEntity;
import cn.acqz.chatgpt.data.domain.weixin.repository.IWeiXinRepository;
import cn.acqz.chatgpt.data.domain.weixin.service.message.filter.TextLogicFilter;
import cn.acqz.lottery.rpc.activity.booth.dto.AwardDTO;
import cn.acqz.lottery.rpc.activity.booth.req.DrawReq;
import cn.acqz.lottery.rpc.activity.booth.res.DrawRes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: 抽奖服务
 */
@Service
public class LotteryLogicFilter extends TextLogicFilter {

    @Resource
    private IWeiXinRepository weiXinRepository;

    @Override
    public String filter(UserBehaviorMessageEntity userBehaviorMessageEntity) {
        DrawReq drawReq = new DrawReq();
        drawReq.setuId(userBehaviorMessageEntity.getOpenId().substring(1, 11));
        drawReq.setActivityId(120981321L);

        DrawRes drawRes = weiXinRepository.doDraw(drawReq);
        if (!"0000".equals(drawRes.getCode())){
            return "抽奖💐 提示：" + drawRes.getInfo();
        }
        //😘
        return "恭喜💐 您已中奖：" + drawRes.getAwardDTO().getAwardName() + "\uD83D\uDE18";
    }

}
