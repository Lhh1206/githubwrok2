package com.lhh.controller;

import com.github.pagehelper.PageInfo;
import com.lhh.pojo.User;
import com.lhh.service.SubjectService;
import com.lhh.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@SuppressWarnings("all")
public class UserController {
    @Resource
    private UserService userService;
   @Resource
   private SubjectService subjectService;
   @RequestMapping("/login.do")
    public String login(String username, String userpwd, Model model, HttpSession session){
        User user = userService.user(username, userpwd);
        Map<String,Object> map=new HashMap<>();
        map.put("index",1);
        map.put("size",2);
        PageInfo list = subjectService.list(map);
        if(user != null){
            session.setAttribute("user",user);
            model.addAttribute("pageinfo",list);
            model.addAttribute("pageindex",list.getPageNum());
            model.addAttribute("pagetolo",list.getPages());
            model.addAttribute("user",user);
            if(user.getVu_status()==2){
                return "votelist";
            }else{
                return"voteweihu";
            }

        }else{
            return "login";
        }

    }

    @RequestMapping("zhuce.do")
    public String zhuce(User user){
        user.setVu_status(2);
        boolean zhuce = userService.zhuce(user);
        if(zhuce){
            return "login";
        }else{
            return "regist";
        }
    }

    @ResponseBody
    @RequestMapping("/verify")
  public boolean verify(String name){
        boolean verify = userService.verify(name);
        return verify;
    }

    @RequestMapping("/exit.do")
    public String exit(HttpSession session){
        session.removeAttribute("user");
        session.invalidate();
        System.out.println("用户注销");
        return "login";
    }








}
