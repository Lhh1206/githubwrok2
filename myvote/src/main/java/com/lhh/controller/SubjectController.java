package com.lhh.controller;

import com.github.pagehelper.PageInfo;
import com.lhh.myconfig.RedisUtil;
import com.lhh.pojo.Subject;
import com.lhh.pojo.User;
import com.lhh.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SuppressWarnings("all")
public class SubjectController {
    @Resource
    private SubjectService subjectService;

    @RequestMapping("/subjectlist.do")
    public String subjectlist(Model model, Integer index, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Map<String, Object> map = new HashMap<>();
        if (index == null) {
            map.put("index", 1);
        } else {
            map.put("index", index);
        }
        map.put("size", 2);
        PageInfo list = subjectService.list(map);
        model.addAttribute("pageinfo", list);
        model.addAttribute("pageindex", list.getPageNum());
        model.addAttribute("pagetolo", list.getPages());
        if (user.getVu_status() == 2) {
            return "votelist";
        } else {
            return "voteweihu";
        }
    }


    @RequestMapping("/subjectbuytj.do")
    public String subjectbuytj(Model model, String subjectname, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Map<String, Object> map = new HashMap<>();
        map.put("index", 1);
        map.put("size", 10);
        map.put("subjectname",subjectname);
        PageInfo list = subjectService.subjectbuytj(map);
        model.addAttribute("pageinfo", list);
        model.addAttribute("pageindex", list.getPageNum());
        model.addAttribute("pagetolo", list.getPages());
        if (user.getVu_status() == 2) {
            return "votelist";
        } else {
            return "voteweihu";
        }
    }

    @ResponseBody
    @RequestMapping("add.do")
    public boolean add(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user.getVu_status() == 2) {
            return false;
        } else {
            return true;
        }
    }

    @ResponseBody
    @RequestMapping("/weihu.do")
    public boolean weihu(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user.getVu_status() == 2) {
            return false;
        } else {
            return true;
        }
    }

    @RequestMapping("/xinzen.do")
    public String xinzen(Model model, HttpSession session, String subjecttitle, String subjecttype, @RequestParam List<String> options) {
        boolean xinzensubject = subjectService.xinzensubject(subjecttitle, Integer.valueOf(subjecttype));
        if (xinzensubject) {
            int maxid = subjectService.maxid();
            for (int i = 0; i < options.size(); i++) {
                boolean xinzenoption = subjectService.xinzenoption(maxid, options.get(i), i + 1);
            }
            return subjectlist(model, 1, session);
        }
        return "add";
    }

    @RequestMapping("/update.do")
    public String update(Model model, HttpSession session, String vsid, String subjecttitle, String subjecttype, @RequestParam List<String> options) {
        System.out.println("vsid--" + vsid);
        boolean updatetitlie = subjectService.updatetitlie(subjecttitle, Integer.valueOf(subjecttype), Integer.valueOf(vsid));
        boolean deleteoption = subjectService.deleteoption(Integer.valueOf(vsid));
        if (updatetitlie) {
            for (int i = 0; i < options.size(); i++) {
                boolean xinzenoption = subjectService.xinzenoption(Integer.valueOf(vsid), options.get(i), i + 1);
            }
            return subjectlist(model, 1, session);
        }
        return subjectlist(model, 1, session);
    }

}
