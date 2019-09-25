package com.matong.lq.matong.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author LiuQiang
 * @Date 2019/9/18 21:22
 * @Version 1.0
 */
@Component
@Data
public class GithubUser {
    private Long id;
    private String bio;
    private String name;
    private String avatar_url;

}
