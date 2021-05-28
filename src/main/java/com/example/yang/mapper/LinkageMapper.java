package com.example.yang.mapper;

import com.example.yang.pojo.Linkage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LinkageMapper {
    List<Linkage> getLinkages();
}
