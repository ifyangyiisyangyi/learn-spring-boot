package com.example.yang.conrtrollers.tools;

import com.example.yang.pojo.ProblemRecord;
import com.example.yang.result.ResultVO;
import com.example.yang.service.ProblemRecordService;
import com.example.yang.util.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.example.yang.result.ResultCode.SUCCESS;


@RestController
@RequestMapping(value = "/problem")
public class ProblemRecordController {
    @Resource
    ProblemRecordService problemRecordService;

    // 分页查询
    @PostMapping(value = "/list")
    public Object findPage(@RequestBody PageRequest pageRequest) {

        return problemRecordService.findPage(pageRequest);
    }

    // 新增
    @PostMapping(value = "/add")
    public ResultVO insertProblemRecord(@RequestBody ProblemRecord problemRecord){
        return new ResultVO(SUCCESS, problemRecordService.insertProblemRecord(problemRecord));
    }

    // 修改
    @PostMapping(value = "/update")
    public ResultVO updateProblemRecord(@RequestBody ProblemRecord problemRecord) {
        return new ResultVO(SUCCESS, problemRecordService.updateProblemRecord(problemRecord));
    }

    // 删除
    @PostMapping(value = "/delete")
    public ResultVO deleteProblemRecord(@RequestBody ProblemRecord problemRecord) {
        int id = problemRecord.getId();
        return new ResultVO(SUCCESS, problemRecordService.deleteProblemRecord(id));
    }
}
