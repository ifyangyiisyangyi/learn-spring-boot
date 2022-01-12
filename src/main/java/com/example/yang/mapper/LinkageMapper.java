package com.example.yang.mapper;

import com.example.yang.pojo.Linkage;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface LinkageMapper {
    /**
     * 查询全部
     *
     * @return
     */
    List<Linkage> getLinkages();

    /**
     * 添加
     *
     * @param linkage
     * @return
     */
    Linkage addLinkage(Linkage linkage);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Linkage delLinkage(Integer id);

    /**
     * 更新
     *
     * @param linkage
     * @return
     */
    Linkage updateLinkage(Linkage linkage);
}
