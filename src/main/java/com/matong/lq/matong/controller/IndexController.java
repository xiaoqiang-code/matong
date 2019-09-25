package com.matong.lq.matong.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.matong.lq.matong.dto.QuestionDTO;
import com.matong.lq.matong.entity.User;
import com.matong.lq.matong.service.QuestionDTOService;
import com.matong.lq.matong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description
 * @Author LiuQiang
 * @Date 2019/9/18 18:18
 * @Version 1.0
 */
@Controller
public class IndexController {
    @Autowired
    private UserService us;
    @Autowired
    private QuestionDTOService qdtos;
    @Autowired
    private HttpServletRequest request;
    @RequestMapping("/")
    public String index(Model model,@RequestParam(defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum,20);
        List<QuestionDTO> list = qdtos.selectQuestionDTOList();
        PageInfo<QuestionDTO> pageInfo = new PageInfo<QuestionDTO>(list);
        model.addAttribute("pageInfo",pageInfo);
        Cookie[] cookies = request.getCookies();
        if(cookies==null){
            return "index";
        }
        for (Cookie cookie:cookies){
            if ("token".equals(cookie.getName())){
                String token = cookie.getValue();
                User user = us.selectUser(token);
                if (user!=null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        return "index";
    }
}
