package com.example.yang.service;

import com.example.yang.mapper.QaReportMapper;
import com.example.yang.pojo.Linkage;
import com.example.yang.pojo.QaReport;
import com.example.yang.util.PageRequest;
import com.example.yang.util.PageResult;
import com.example.yang.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "QaReportService")
public class QaReportImpl implements QaReportService {
    @Resource
    private QaReportMapper qaReportMapper;
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    private PageInfo<?> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<QaReport> sysMenus = qaReportMapper.selectAll();
        return new PageInfo<>(sysMenus);
    }
}
