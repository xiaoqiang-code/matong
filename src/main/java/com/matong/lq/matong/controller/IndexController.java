package com.matong.lq.matong.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.matong.lq.matong.dto.QuestionDTO;
import com.matong.lq.matong.entity.User;
import com.matong.lq.matong.service.QuestionDTOService;
import com.matong.lq.matong.service.UserService;
import com.matong.lq.matong.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    //跳转到登录页
    @RequestMapping("/login")
    public String myLogin(Model model){
        model.addAttribute("error","");
        return "login/index";
    }
    //跳转到注册页
    @RequestMapping("/register")
    public String myRegister(){
        return "login/register";
    }
    //用户注册
    @RequestMapping("/userRegister")
    public String userRegister(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password,Model model){
        int i =(int) (Math.random() * 1000000000);
        String a=""+i;
        model.addAttribute("error","");
        Date date=new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format( date );
        us.userRegister(a,username,time,time,"qweqweqweqweqwe",password);
        return "login/index";
    }
    //用户登录
    @RequestMapping("/userLogin")
    public String userLogin(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password,Model model,@RequestParam(defaultValue = "1") Integer pageNum){
        User user = us.userLogin(username);
        if(user!=null&&user.getPassword().equals(password)){
            PageHelper.startPage(pageNum,20);
            List<QuestionDTO> list = qdtos.selectQuestionDTOList();
            PageInfo<QuestionDTO> pageInfo = new PageInfo<QuestionDTO>(list);
            model.addAttribute("pageInfo",pageInfo);
            request.getSession().setAttribute("user",user);
            return "index";
        }else{
            model.addAttribute("error","用户名或密码错误！");
            return "login/index";

        }
    }
    //用户退出
    @RequestMapping("/userExit")
    public String userExit(Model model,@RequestParam(defaultValue = "1") Integer pageNum){
        HttpSession session = request.getSession();
        session.invalidate();
        PageHelper.startPage(pageNum,20);

        List<QuestionDTO> list = qdtos.selectQuestionDTOList();
        PageInfo<QuestionDTO> pageInfo = new PageInfo<QuestionDTO>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }
}
