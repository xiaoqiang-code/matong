package com.matong.lq.matong.service;

import com.matong.lq.matong.entity.Question;
import java.util.List;


public interface QuestionService {
    public void insertQuestion(String title,String description,String gmt_create,String gmt_modified,int creator,String tag);
}
