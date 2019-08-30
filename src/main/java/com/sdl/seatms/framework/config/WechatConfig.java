package com.sdl.seatms.framework.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author majingyuan
 * @Date Create in 2017/11/23 16:55
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechatconfig")
public class WechatConfig {
    private String corpId;
    private Integer agentId;
    private String secret;
}
