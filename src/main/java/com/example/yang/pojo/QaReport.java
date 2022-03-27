package com.example.yang.pojo;

import java.util.Date;
import lombok.Data;

@Data
public class QaReport {
    private Integer id;

    /**
    * prd地址
    */
    private String prdAddr;

    /**
    * 开发文档地址
    */
    private String devAddr;

    /**
    * qa
    */
    private String qa;

    /**
    * dev
    */
    private String dev;

    /**
    * open bug
    */
    private Integer openBug;

    /**
    * close bug
    */
    private String closeBug;

    /**
    * bug总数
    */
    private String totalBug;

    /**
    * 测试总结
    */
    private String summary;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 更新时间
    */
    private Date updateTime;
}