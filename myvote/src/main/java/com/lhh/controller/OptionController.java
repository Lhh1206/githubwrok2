package com.lhh.controller;

import com.lhh.pojo.Option;
import com.lhh.pojo.Subject;
import com.lhh.pojo.User;
import com.lhh.service.OptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@SuppressWarnings("all")
public class OptionController {
    @Resource
    private OptionService optionService;

    @RequestMapping("/optionbuylist.do")
    public String optionbuylist(Model model, Integer index, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("utf-8");
       response.setContentType("text/html;charset=UTF-8");
        User user = (User) session.getAttribute("user");
        PrintWriter out = response.getWriter();
        Subject subjectbuyid = optionService.subjectbuyid(index);
        List<Option> optionlist = optionService.optionlist(index);
        model.addAttribute("subjectbuyid", subjectbuyid);
        model.addAttribute("optionlist", optionlist);
        boolean count = optionService.count(user.getVu_user_id(),index);
        if (count) {
            out.print("<script>");
            out.print("alert('每人只有一次机会');");
            out.print("location.href='subjectlist.do';");
            out.print("</script>");
        }
        return "vote";
    }


    @RequestMapping("/optionbuyview.do")
    public String optionbuyview(Model model, Integer index, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Subject subjectbuyid = optionService.subjectbuyid(index);
        List<Option> optionlist = optionService.optionlist(index);
        model.addAttribute("subjectbuyid", subjectbuyid);
        model.addAttribute("optionlist", optionlist);
        return "voteview";
    }

    @RequestMapping("/weihuupdate.do")
    public String weihuupdate(Model model, Integer index, HttpSession session) {
        Subject subjectbuyid = optionService.subjectbuyid(index);
        List<Option> optionlist = optionService.optionlist(index);
        model.addAttribute("subjectbuyid", subjectbuyid);
        model.addAttribute("optionlist", optionlist);
        return "weihuupdate";
    }

}
