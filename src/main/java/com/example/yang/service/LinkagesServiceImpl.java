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


    @Override
    public List<Linkage> getLinkages() {
        List<Linkage> linkages = linkageMapper.getLinkages();
        return linkages;
    }

    @Override
    public Boolean addLinkage(Linkage linkage) {
        linkageMapper.addLinkage(linkage);
        return true;
    }
}
