package com.example.yang.conrtrollers.tools;


import com.alibaba.fastjson.JSONObject;
import com.example.yang.pojo.Bot;
import com.example.yang.pojo.ProblemRecord;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/feishu")
public class FeishuBot {
    @PostMapping(value = "/bot")
    public JSONObject  bot(@RequestBody Bot bot){
        JSONObject jsonObj = new JSONObject();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("challenge",bot.getChallenge());
        jsonObj.putAll(map);
        return jsonObj;
    }
}
