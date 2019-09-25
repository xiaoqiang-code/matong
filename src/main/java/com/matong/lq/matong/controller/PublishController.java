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

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }
    @PostMapping("/publish")
    public String doPublish(@RequestParam(value = "title") String title, @RequestParam(value = "description") String description, @RequestParam(value = "tag") String tag, Model model){
        Date date=new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format( date );
        User user=null;
        Cookie[] cookies = request.getCookies();
        if(cookies==null){
            return "index";
        }
        for (Cookie cookie:cookies){
            if ("token".equals(cookie.getName())){
                String token = cookie.getValue();
                user = us.selectUser(token);
                if (user==null){
                    model.addAttribute("inf","用户未登录");
                    return "publish";
                }else{
                    qs.insertQuestion(title,description,time,time,user.getId(),tag);
                    model.addAttribute("inf","发布成功！");
                }

            }
        }
        return "publish";
    }
}
