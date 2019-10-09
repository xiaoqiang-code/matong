package com.matong.lq.matong.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.matong.lq.matong.dto.QuestionDTO;
import com.matong.lq.matong.entity.User;
import com.matong.lq.matong.service.QuestionDTOService;
import com.matong.lq.matong.service.UserService;
import com.mysql.cj.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description
 * @Author LiuQiang
 * @Date 2019/9/28 12:36
 * @Version 1.0
 */
@Controller
public class ProfileController {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService us;

    @Autowired
    private QuestionDTOService qdtos;

    @RequestMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action, Model model,@RequestParam(defaultValue = "1") Integer pageNum){
//        Cookie[] cookies = request.getCookies();
//        if(cookies==null){
//            return "index";
//        }
//        User user=null;
//        System.out.println("%%%%%%%%%%%%%%%%%%%%"+cookies);
//        for (Cookie cookie:cookies){
//            System.out.println(111111111);
//            if ("token".equals(cookie.getName())){
//                System.out.println(222222222);
//                String token = cookie.getValue();
//                System.out.println("%%%%%%%%%%%%%%%%%%%%"+token);
//                user = us.selectUser(token);
//                if (user!=null){
//                    request.getSession().setAttribute("user",user);
//                }
//                break;
//            }
//        }
        User user =(User) request.getSession().getAttribute("user");
        if(user==null){
            return "/";
        }else{
            PageHelper.startPage(pageNum,20);
            if ("question".equals(action)) {
                List<QuestionDTO> list = qdtos.selectQuestionDTOListByUserId(Integer.parseInt(user.getAccount_id()));
                PageInfo<QuestionDTO> pageInfo = new PageInfo<QuestionDTO>(list);
                model.addAttribute("pageInfo",pageInfo);
                model.addAttribute("section","questions");
                model.addAttribute("sectionName","我的发布");
            } else if ("replay".equals(action)) {
                model.addAttribute("section","replay");
                model.addAttribute("sectionName","最新回复");
            }
            return "profile";
        }

    }
}
