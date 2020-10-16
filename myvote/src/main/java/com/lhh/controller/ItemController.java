package com.lhh.controller;

import com.lhh.pojo.Item;
import com.lhh.pojo.User;
import com.lhh.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SuppressWarnings("all")
public class ItemController {
    @Resource
    private ItemService itemService;

    @ResponseBody
    @RequestMapping("/toupiao.do")
    public boolean toupiao(Model model, HttpSession session, Integer vpid, Integer vsid) {
        System.out.println("vpid--" + vpid);
        System.out.println("vsid--" + vsid);
        User user = (User) session.getAttribute("user");
        Item item = new Item();
        item.setVu_user_id(user.getVu_user_id());
        item.setVs_id(vsid);
        item.setVo_id(vpid);
        boolean toupiao = itemService.toupiao(item);
        if (toupiao) {
            return true;
        } else {
            return false;
        }
    }


    @ResponseBody
    @RequestMapping("/ftoupiao.do")
    public boolean ftoupiao(Model model, HttpSession session, @RequestParam String[] checkID, Integer vsid) {
        User user = (User) session.getAttribute("user");
        boolean flag = false;
        for (int i = 0; i < checkID.length; i++) {
            Item item = new Item();
            item.setVu_user_id(user.getVu_user_id());
            item.setVs_id(vsid);
            item.setVo_id(Integer.valueOf(checkID[i]));
            flag = itemService.toupiao(item);
        }
        if (flag) {
            System.out.println("flag成功--"+flag);
            return true;
        } else {
            return false;
        }
    }
}
