package com.matong.lq.matong.dto;


import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author LiuQiang
 * @Date 2019/9/18 21:22
 * @Version 1.0
 */
@Component
public class GithubUser {
    private Long id;
    private String bio;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GithubUser{" +
                "id=" + id +
                ", bio='" + bio + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
