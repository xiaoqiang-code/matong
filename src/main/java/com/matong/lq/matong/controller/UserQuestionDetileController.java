package com.matong.lq.matong.controller;

import com.matong.lq.matong.dto.QuestionDTO;
import com.matong.lq.matong.service.QuestionDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author LiuQiang
 * @Date 2019/9/30 15:01
 * @Version 1.0
 */
@Controller
public class UserQuestionDetileController {
    @Autowired
    private QuestionDTOService qdtos;
    @Autowired
    HttpServletRequest request;
    
    @RequestMapping("/userQuestionDetile")
    public String userQuestionDetile(Model model){
        String questionId = request.getParameter("questionId");
        String questionName = request.getParameter("questionName");
        QuestionDTO questionDTO = qdtos.selectUserQuestionDetile(Integer.parseInt(questionId),questionName);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
