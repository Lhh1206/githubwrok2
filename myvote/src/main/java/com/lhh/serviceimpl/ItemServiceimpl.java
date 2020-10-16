package com.lhh.serviceimpl;

import com.lhh.dao.ItemDao;
import com.lhh.pojo.Item;
import com.lhh.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ItemServiceimpl implements ItemService {

    @Resource
    private ItemDao itemDao;
    @Override
    public boolean toupiao(Item item) {
        int toupiao = itemDao.toupiao(item);
        return toupiao>0;
    }
}
