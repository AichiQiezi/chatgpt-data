package cn.acqz.chatgpt.data.trigger.http.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qz
 * @description
 * @date 2023-07-16 08:45
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageEntity {

    private String role;
    private String content;
    private String name;

}