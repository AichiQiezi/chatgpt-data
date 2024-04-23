package cn.acqz.chatgpt.data.domain.order.repository;

import cn.acqz.chatgpt.data.domain.order.model.aggregates.CreateOrderAggregate;
import cn.acqz.chatgpt.data.domain.order.model.entity.PayOrderEntity;
import cn.acqz.chatgpt.data.domain.order.model.entity.ProductEntity;
import cn.acqz.chatgpt.data.domain.order.model.entity.ShopCartEntity;
import cn.acqz.chatgpt.data.domain.order.model.entity.UnpaidOrderEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author qz
 * @description 订单仓储接口
 * @date 2023-10-05 13:11
 */
public interface IOrderRepository {


    UnpaidOrderEntity queryUnpaidOrder(ShopCartEntity shopCartEntity);

    ProductEntity queryProduct(Integer productId);

    void saveOrder(CreateOrderAggregate aggregate);

    void updateOrderPayInfo(PayOrderEntity payOrderEntity);

    boolean changeOrderPaySuccess(String orderId, String transactionId, BigDecimal totalAmount, Date payTime);

    CreateOrderAggregate queryOrder(String orderId);

    void deliverGoods(String orderId);

    List<String> queryReplenishmentOrder();

    List<String> queryNoPayNotifyOrder();

    List<String> queryTimeoutCloseOrderList();

    boolean changeOrderClose(String orderId);

    List<ProductEntity> queryProductList();

}
