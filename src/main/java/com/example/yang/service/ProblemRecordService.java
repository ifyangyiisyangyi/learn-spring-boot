package com.example.yang.service;

import com.example.yang.pojo.ProblemRecord;
import com.example.yang.util.PageRequest;
import com.example.yang.util.PageResult;

public interface ProblemRecordService {
    PageResult findPage(PageRequest pageRequest);
    int insertProblemRecord(ProblemRecord problemRecord);
    int updateProblemRecord(ProblemRecord problemRecord);
    Integer deleteProblemRecord(int id);
}
