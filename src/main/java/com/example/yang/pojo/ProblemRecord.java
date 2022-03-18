package com.example.yang.pojo;

import lombok.Data;

@Data
public class ProblemRecord {
    // id
    private Integer id;
    // 标题
    private String title;
    // 所属功能
    private String function;
    // 问题描述
    private String describe;
    // 发现时间
    private String discoverTime;
    // 关闭时间
    private String endTime;
    // 跟进过程
    private String followUpProcess;
    // 问题总结
    private String summary;
    // 责任qa
    private String qa;
    // 责任开发
    private String dev;
}
