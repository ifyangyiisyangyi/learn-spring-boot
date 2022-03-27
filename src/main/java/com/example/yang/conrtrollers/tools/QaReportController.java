package com.example.yang.conrtrollers.tools;

import com.example.yang.result.ResultVO;
import com.example.yang.service.QaReportService;
import com.example.yang.util.PageRequest;
import com.example.yang.util.PageResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.example.yang.result.ResultCode.SUCCESS;

@RestController
@RequestMapping(value = "/report")
public class QaReportController {

    @Resource
    QaReportService qaReportService;

    @PostMapping(value = "/list")
    public ResultVO selectAll(@RequestBody PageRequest pageRequest){
        return new ResultVO(SUCCESS, qaReportService.findPage(pageRequest));
    }
}
