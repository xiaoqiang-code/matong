package com.matong.lq.matong.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description
 * @Author LiuQiang
 * @Date 2019/9/18 20:52
 * @Version 1.0
 */
@Setter
@Getter
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
