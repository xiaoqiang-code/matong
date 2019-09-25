package com.matong.lq.matong.entity;

import lombok.Data;

/**
 * @Description
 * @Author LiuQiang
 * @Date 2019/9/22 12:00
 * @Version 1.0
 */
@Data
public class Question {
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

}
