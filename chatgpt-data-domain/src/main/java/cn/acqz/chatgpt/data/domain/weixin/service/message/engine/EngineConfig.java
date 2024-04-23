package cn.acqz.chatgpt.data.domain.weixin.service.message.engine;

import cn.acqz.chatgpt.data.domain.weixin.service.message.filter.LogicFilter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author qz
 * @description 过滤器初始化
 * @date 2024/4/19
 */
public class EngineConfig {
    @Resource
    private Map<String, LogicFilter> logicFilterMap = new HashMap<>();

    protected static Map<String, Map<String, LogicFilter>> logicFilterMaps = new HashMap<>();

    @PostConstruct
    public void init() {
        this.logicFilterMap = logicFilterMap.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().replace("LogicFilter", ""),
                        Map.Entry::getValue
                ));

        logicFilterMaps.put("text", new HashMap<String, LogicFilter>() {{
            put("lottery", logicFilterMap.get("lottery"));
            put("captcha", logicFilterMap.get("captcha"));
            put("default", logicFilterMap.get("hello"));
        }});
        logicFilterMaps.put("event", new HashMap<String, LogicFilter>() {{
            put("subscribe", logicFilterMap.get("subscribe"));
            put("unsubscribe", logicFilterMap.get("unsubscribe"));
        }});
        System.out.println();
    }

}
