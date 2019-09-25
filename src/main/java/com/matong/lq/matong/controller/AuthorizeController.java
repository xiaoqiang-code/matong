package com.matong.lq.matong.controller;

import com.matong.lq.matong.dto.AccessTokenDTO;
import com.matong.lq.matong.dto.GithubUser;
import com.matong.lq.matong.provider.GithubProvider;
import com.matong.lq.matong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Description
 * @Author LiuQiang
 * @Date 2019/9/18 19:40
 * @Version 1.0
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Autowired
    private UserService us;
    @Autowired
    private GithubUser gu;
    @Value("${github.client_id}")
    private String client_id;
    @Value("${github.client_secret}")
    private String client_secret;
    @Value("${github.redirect_uri}")
    private String redirect_uri;

    @RequestMapping("/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state,  HttpServletResponse response){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        if(user!=null){
            gu.setId(user.getId());
            gu.setName(user.getName());
            gu.setAvatar_url(user.getAvatar_url());
            Date date=new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = dateFormat.format( date );
            String token = UUID.randomUUID().toString();
            us.insert(String.valueOf(user.getId()),user.getName(), token,time,time,user.getAvatar_url());
            response.addCookie(new Cookie("token",token));
            return "redirect:/";
        }else{
            return "index";
        }
    }
}
