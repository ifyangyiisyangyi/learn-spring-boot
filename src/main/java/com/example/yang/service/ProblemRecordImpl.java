package com.example.yang.service;

import com.example.yang.mapper.ProblemRecordMapper;
import com.example.yang.pojo.ProblemRecord;
import com.example.yang.util.PageRequest;
import com.example.yang.util.PageResult;
import com.example.yang.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service(value = "ProblemRecordService")
public class ProblemRecordImpl implements ProblemRecordService{
    @Resource
    private ProblemRecordMapper problemRecordMapper;

    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    @Override
    public int insertProblemRecord(ProblemRecord problemRecord) {
        log.info(String.valueOf(problemRecord));
        return problemRecordMapper.insertProblemRecord(problemRecord);
    }

    @Override
    public int updateProblemRecord(ProblemRecord problemRecord) {
        log.info("修改：" + problemRecord);
        return problemRecordMapper.updateProblemRecord(problemRecord);
    }

    public Integer deleteProblemRecord(int id) {
        log.info("删除:" + id);
        return problemRecordMapper.deleteProblemRecord(id);
    }

    /**
     * 调用分页插件完成分页
     *
     * @param pageRequest
     * @return
     */
    private PageInfo<ProblemRecord> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<ProblemRecord> sysMenus = problemRecordMapper.getProblemRecord();
        return new PageInfo<>(sysMenus);
    }

}
