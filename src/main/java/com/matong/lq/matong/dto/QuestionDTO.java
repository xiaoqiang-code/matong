package com.matong.lq.matong.dto;

import com.matong.lq.matong.entity.User;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author LiuQiang
 * @Date 2019/9/24 11:12
 * @Version 1.0
 */
@Data
@Component
public class QuestionDTO {
    private int id;
    private String title;
    private String description;
    private String gmt_create;
    private String gmt_modified;
    private int creator;
    private int comment_count;
    private int view_count;
    private int like_count;
    private int unlike_count;
    private String tag;
    private String account_id;
    private String name;
    private String token;
    private String pic_url;
}
