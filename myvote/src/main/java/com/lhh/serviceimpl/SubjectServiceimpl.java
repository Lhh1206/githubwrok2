package com.lhh.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhh.dao.SubjectDao;
import com.lhh.myconfig.RedisUtil;
import com.lhh.pojo.Subject;
import com.lhh.service.SubjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@SuppressWarnings("all")
public class SubjectServiceimpl implements SubjectService {
    @Resource
    private SubjectDao subjectDao;
    //引入redis模板
    @Resource
    private RedisUtil redisUtil;
    @Override
    public boolean updatetitlie(String title, Integer type,Integer vsid) {
        return subjectDao.updatetitlie(title, type,vsid) > 0;
    }

    @Override
    public boolean deleteoption(Integer vsid) {
        return subjectDao.deleteoption(vsid) > 0;
    }

    @Override
    public PageInfo subjectbuytj(Map<String ,Object> map) {
        Integer index = Integer.valueOf(map.get("index").toString());
        Integer size = Integer.valueOf(map.get("size").toString());
        String subjectname=map.get("subjectname").toString();
        PageHelper.startPage(index, size);
        List<Subject> subjectbuytj = subjectDao.subjectbuytj(subjectname);
        PageInfo pageInfo = new PageInfo(subjectbuytj);
        return pageInfo;
    }

    @Override
    public PageInfo list(Map<String, Object> map) {
        Integer index = Integer.valueOf(map.get("index").toString());
        Integer size = Integer.valueOf(map.get("size").toString());
        List<Subject> list=null;
        boolean subjectbuyfy = redisUtil.exists("subjectbuyfy");
        PageHelper.startPage(index, size);
        if(index==1){
            if(subjectbuyfy ){
                System.out.println("redis中有缓存,直接中redis中拿");
                list=(List<Subject>) redisUtil.get("subjectbuyfy");
            }else{
                System.out.println("redis中没有缓存,从数据库拿");
                list = subjectDao.list();
                redisUtil.set("subjectbuyfy",list);
            }
        }else{
            list = subjectDao.list();
        }

         PageInfo    pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public boolean xinzensubject(String title, Integer type) {
        return subjectDao.xinzensubject(title, type) > 0;
    }

    @Override
    public boolean xinzenoption(Integer vsid, String optionname, Integer order) {
        return subjectDao.xinzenoption(vsid, optionname, order) > 0;
    }

    @Override
    public int maxid() {
        return subjectDao.maxid();
    }
}
