package com.matong.lq.matong.ServiceImpl;

import com.matong.lq.matong.dto.QuestionDTO;
import com.matong.lq.matong.mapper.QuestionDTOMapper;
import com.matong.lq.matong.mapper.QuestionMapper;
import com.matong.lq.matong.service.QuestionDTOService;
import com.matong.lq.matong.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author LiuQiang
 * @Date 2019/9/24 21:45
 * @Version 1.0
 */
@Service
@Transactional
public class QuestionDTOServiceImpl implements QuestionDTOService {
    @Autowired
    private QuestionDTOMapper qdtom;
    @Override
    public List<QuestionDTO> selectQuestionDTOList() {
        List<QuestionDTO> questionDTOS = qdtom.selectQuestionDTOList();
        return questionDTOS;
    }

    @Override
    public List<QuestionDTO> selectQuestionDTOListByUserId(int id) {
        List<QuestionDTO> questions = qdtom.selectQuestionDTOListByUserId(id);
        return questions;
    }

    @Override
    public QuestionDTO selectUserQuestionDetile(int id,String name) {
        QuestionDTO questionDTO = qdtom.selectUserQuestionDetile(id,name);
        return questionDTO;
    }
}
