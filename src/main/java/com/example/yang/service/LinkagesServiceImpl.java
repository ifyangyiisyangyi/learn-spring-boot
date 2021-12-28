package com.example.yang.service;

import com.example.yang.mapper.LinkageMapper;
import com.example.yang.pojo.Linkage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "LinkageService")
public class LinkagesServiceImpl implements LinkagesService {
    @Resource
    private LinkageMapper linkageMapper;

    // 获取link列表
    @Override
    public List<Linkage> getLinkages() {
        List<Linkage> linkages = linkageMapper.getLinkages();
        return linkages;
    }

    //添加
    @Override
    public Boolean addLinkage(Linkage linkage) {
        linkageMapper.addLinkage(linkage);
        return true;
    }

    // 删除
    @Override
    public Boolean delLinkage(Integer id) {
        linkageMapper.delLinkage(id);
        return true;
    }

    // 修改
    public Linkage updateLinkage(Linkage linkage){
        linkageMapper.updateLinkage(linkage);
        return  linkage;

    }
}
