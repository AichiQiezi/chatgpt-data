package cn.acqz.chatgpt.data;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author qz
 * @description 启动类
 * @date 2023-07-16 07:43
 */
@SpringBootApplication
@Configurable
@EnableScheduling
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }

}
