package com.example.yang.mapper;

import com.example.yang.pojo.ProblemRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProblemRecordMapper {
    List<ProblemRecord> getProblemRecord();
    int insertProblemRecord(ProblemRecord problemRecord);
    int updateProblemRecord(ProblemRecord problemRecord);
    int deleteProblemRecord(int id);
}
