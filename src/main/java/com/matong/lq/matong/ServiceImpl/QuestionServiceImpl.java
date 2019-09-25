package com.matong.lq.matong.ServiceImpl;

import com.matong.lq.matong.entity.Question;
import com.matong.lq.matong.mapper.QuestionMapper;
import com.matong.lq.matong.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author LiuQiang
 * @Date 2019/9/22 12:14
 * @Version 1.0
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper qm;
    @Override
    public void insertQuestion(String title, String description, String gmt_create, String gmt_modified, int creator, String tag) {
        Question question=new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setGmt_create(gmt_create);
        question.setGmt_modified(gmt_modified);
        question.setCreator(creator);
        question.setTag(tag);
        qm.insertQuestion(question);
    }
}
