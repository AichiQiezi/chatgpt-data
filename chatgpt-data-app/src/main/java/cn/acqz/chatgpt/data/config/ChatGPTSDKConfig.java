package cn.acqz.chatgpt.data.config;

import cn.acqz.chatgpt.session.OpenAiSession;
import cn.acqz.chatgpt.session.OpenAiSessionFactory;
import cn.acqz.chatgpt.session.defaults.DefaultOpenAiSessionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qz
 * @description ChatGPTSDKConfig 工厂配置开启
 * @date 2023-07-16 08:07
 */
@Configuration
@EnableConfigurationProperties(ChatGPTSDKConfigProperties.class)
public class ChatGPTSDKConfig {

    @Bean(name = "chatGPTOpenAiSession")
    @ConditionalOnProperty(value = "chatgpt.sdk.config.enabled", havingValue = "true", matchIfMissing = false)
    public OpenAiSession openAiSession(ChatGPTSDKConfigProperties properties) {
        // 1. 配置文件
        cn.acqz.chatgpt.session.Configuration configuration = new cn.acqz.chatgpt.session.Configuration();
        configuration.setApiHost(properties.getApiHost());
        configuration.setApiKey(properties.getApiKey());

        // 2. 会话工厂
        OpenAiSessionFactory factory = new DefaultOpenAiSessionFactory(configuration);

        // 3. 开启会话
        return factory.openSession();
    }

}
