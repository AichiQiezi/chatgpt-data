package cn.acqz.chatgpt.data.infrastructure.dao;

import cn.acqz.chatgpt.data.infrastructure.po.OpenAIOrderPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author qz
 * @description 订单Dao
 * @date 2023-10-05 13:27
 */
@Mapper
public interface IOpenAIOrderDao {

    OpenAIOrderPO queryUnpaidOrder(OpenAIOrderPO openAIOrderPOReq);

    void insert(OpenAIOrderPO order);

    void updateOrderPayInfo(OpenAIOrderPO openAIOrderPO);

    int changeOrderPaySuccess(OpenAIOrderPO openAIOrderPO);

    OpenAIOrderPO queryOrder(String orderId);

    int updateOrderStatusDeliverGoods(String orderId);

    List<String> queryReplenishmentOrder();

    List<String> queryNoPayNotifyOrder();

    List<String> queryTimeoutCloseOrderList();

    boolean changeOrderClose(String orderId);

}
