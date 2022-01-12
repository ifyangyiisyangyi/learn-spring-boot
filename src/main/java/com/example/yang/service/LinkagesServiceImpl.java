package com.example.yang.service;

import com.example.yang.mapper.LinkageMapper;
import com.example.yang.pojo.Linkage;
import com.example.yang.util.PageRequest;
import com.example.yang.util.PageResult;
import com.example.yang.util.PageUtils;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "LinkageService")
public class LinkagesServiceImpl implements LinkagesService {
    @Resource
    private LinkageMapper linkageMapper;

    //添加
    @Override
    public Linkage addLinkage(Linkage linkage) {
        linkageMapper.addLinkage(linkage);
        return linkage;
    }

    // 删除
    @Override
    public Boolean delLinkage(Integer id) {
        linkageMapper.delLinkage(id);
        return true;
    }

    // 修改
    @Override
    public Linkage updateLinkage(Linkage linkage) {
        linkageMapper.updateLinkage(linkage);
        return linkage;
    }

    // 查询
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     *
     * @param pageRequest
     * @return
     */
    private PageInfo<Linkage> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Linkage> sysMenus = linkageMapper.getLinkages();
        return new PageInfo<Linkage>(sysMenus);
    }

}
