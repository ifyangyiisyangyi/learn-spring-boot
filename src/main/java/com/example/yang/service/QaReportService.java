package com.example.yang.service;

import com.example.yang.util.PageRequest;
import com.example.yang.util.PageResult;

public interface QaReportService {
    PageResult findPage(PageRequest pageRequest);
}
