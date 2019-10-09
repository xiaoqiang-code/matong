package com.matong.lq.matong.controller;

import com.matong.lq.matong.entity.User;
import com.matong.lq.matong.service.QuestionService;
import com.matong.lq.matong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @Author LiuQiang
 * @Date 2019/9/22 11:37
 * @Version 1.0
 */
@Controller
public class PublishController {
    @Autowired
    private QuestionService qs;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService us;
    //打开发布页
    @RequestMapping("/publishs")
    public String publishUrl(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(@RequestParam(value = "title") String title, @RequestParam(value = "description") String description, @RequestParam(value = "tag") String tag, Model model){
        Date date=new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format( date );

        User user =(User) request.getSession().getAttribute("user");
        if(user!=null) {
            qs.insertQuestion(title,description,time,time,Integer.parseInt(user.getAccount_id()),tag);
        }else {
            model.addAttribute("inf","用户未登录");
            return "publish";
        }
        return "publish";
    }
}
