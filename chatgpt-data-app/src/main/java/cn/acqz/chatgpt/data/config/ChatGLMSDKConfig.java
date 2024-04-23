package cn.acqz.chatgpt.data.config;

import cn.acqz.chatglm.session.OpenAiSession;
import cn.acqz.chatglm.session.OpenAiSessionFactory;
import cn.acqz.chatglm.session.defaults.DefaultOpenAiSessionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qz
 * @description ChatGLMSDKConfig 工厂配置开启
 * @date 2023-10-14 16:00
 */
@Configuration
@EnableConfigurationProperties(ChatGLMSDKConfigProperties.class)
public class ChatGLMSDKConfig {

    @Bean(name = "chatGlMOpenAiSession")
    @ConditionalOnProperty(value = "chatglm.sdk.config.enabled", havingValue = "true", matchIfMissing = false)
    public OpenAiSession openAiSession(ChatGLMSDKConfigProperties properties) {
        // 配置文件
        cn.acqz.chatglm.session.Configuration configuration = new cn.acqz.chatglm.session.Configuration();
        configuration.setApiHost(properties.getApiHost());
        configuration.setApiSecretKey(properties.getApiSecretKey());

        // 会话工厂
        OpenAiSessionFactory factory = new DefaultOpenAiSessionFactory(configuration);

        // 开启会话
        return factory.openSession();
    }

}
