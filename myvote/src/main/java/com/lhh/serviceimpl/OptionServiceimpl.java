package com.lhh.serviceimpl;

import com.lhh.dao.OptionDao;
import com.lhh.pojo.Option;
import com.lhh.pojo.Subject;
import com.lhh.service.OptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OptionServiceimpl implements OptionService {
    @Resource
    private OptionDao optionDao;

    @Override
    public Subject subjectbuyid(Integer id) {
        Subject subjectbuyid = optionDao.subjectbuyid(id);
        return subjectbuyid;
    }

    @Override
    public int toupiaos(Integer vsid, Integer vpid) {
        int toupiaos = optionDao.toupiaos(vsid, vpid);
        return toupiaos;
    }

    @Override
    public boolean count(Integer userid, Integer vsid) {
        return optionDao.count(userid, vsid) > 0;
    }

    @Override
    public List<Option> optionlist(Integer id) {
        List<Option> optionlist = optionDao.optionlist(id);
        for (int i = 0; i < optionlist.size(); i++) {
            int toupiaos = toupiaos(id, optionlist.get(i).getVo_id());
            optionlist.get(i).setPiaoshu(toupiaos);
        }
        return optionlist;
    }
}
