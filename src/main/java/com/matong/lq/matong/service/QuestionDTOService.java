package com.matong.lq.matong.service;

import com.matong.lq.matong.dto.QuestionDTO;

import java.util.List;

public interface QuestionDTOService {
    public List<QuestionDTO> selectQuestionDTOList();
    public List<QuestionDTO> selectQuestionDTOListByUserId(int id);
    public QuestionDTO selectUserQuestionDetile(int id,String name);
}
