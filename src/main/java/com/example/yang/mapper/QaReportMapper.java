package com.example.yang.mapper;

import com.example.yang.pojo.QaReport;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QaReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QaReport record);

    int insertSelective(QaReport record);

    QaReport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QaReport record);

    int updateByPrimaryKey(QaReport record);

    List<QaReport> selectAll();
}