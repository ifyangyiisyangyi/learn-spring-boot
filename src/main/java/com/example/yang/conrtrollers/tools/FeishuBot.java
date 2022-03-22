package com.example.yang.conrtrollers.tools;


import com.alibaba.fastjson.JSONObject;
import com.example.yang.pojo.Bot;
import com.example.yang.pojo.ProblemRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/feishu")
public class FeishuBot {
    @PostMapping(value = "/bot")
    public JSONObject  bot(@RequestBody Bot bot){
        JSONObject jsonObj = new JSONObject();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("challenge",bot.getChallenge());
        jsonObj.putAll(map);
        log.info(String.valueOf(jsonObj));
        System.out.println("********************ok***********");
        return jsonObj;
    }
}
