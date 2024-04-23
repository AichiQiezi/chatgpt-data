package cn.acqz.chatgpt.data.test.domain.order;

import cn.acqz.chatgpt.data.domain.order.model.entity.PayOrderEntity;
import cn.acqz.chatgpt.data.domain.order.model.entity.ShopCartEntity;
import cn.acqz.chatgpt.data.domain.order.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author qz
 * @description 订单服务测试
 * @date 2023-10-05 16:49
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Resource
    private IOrderService orderService;

    @Test
    public void test_createOrder() {
        ShopCartEntity shopCartEntity = ShopCartEntity.builder()
                .openid("xfg-test02")
                .productId(1001)
                .build();
        PayOrderEntity payOrderEntity = orderService.createOrder(shopCartEntity);
        log.info("请求参数：{} 测试结果: {}", shopCartEntity, payOrderEntity);
    }

}
