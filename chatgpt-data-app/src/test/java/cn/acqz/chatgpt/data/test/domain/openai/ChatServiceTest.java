package cn.acqz.chatgpt.data.test.domain.openai;

import cn.acqz.chatgpt.common.Constants;
import cn.acqz.chatgpt.data.domain.openai.model.aggregates.ChatProcessAggregate;
import cn.acqz.chatgpt.data.domain.openai.model.entity.MessageEntity;
import cn.acqz.chatgpt.data.domain.openai.service.IChatService;
import cn.acqz.chatgpt.data.types.enums.ChatGPTModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;

/**
 * @author qz
 * @description 对话测试
 * @date 2023-10-03 18:13
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatServiceTest {

    @Resource
    private IChatService chatService;
    @Test
    public void test_completions() throws InterruptedException {
        ResponseBodyEmitter emitter = new ResponseBodyEmitter();

        ChatProcessAggregate chatProcessAggregate = new ChatProcessAggregate();
        chatProcessAggregate.setOpenid("xfg");
        chatProcessAggregate.setModel(ChatGPTModel.DALL_E_3.getCode());
        chatProcessAggregate.setMessages(Collections.singletonList(MessageEntity.builder().role(Constants.Role.USER.getCode()).content("画一个小狗").build()));

        ResponseBodyEmitter completions = chatService.completions(emitter, chatProcessAggregate);

        // 等待
        new CountDownLatch(1).await();

    }

}
