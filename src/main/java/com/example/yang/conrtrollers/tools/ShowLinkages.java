package com.example.yang.conrtrollers.tools;

import com.example.yang.pojo.Linkage;
import com.example.yang.service.LinkagesService;
import com.example.yang.util.PageRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/linkage")
@Slf4j  // 等同于下面的注释
public class ShowLinkages {
    //    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ShowLinkages.class);
    @Resource
    LinkagesService linkagesService;

    // 新增
    @RequestMapping(value = "/add", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public Linkage addLinkage(@RequestBody Linkage linkage) {
        log.info("add linkage:  " + linkage);
        return linkagesService.addLinkage(linkage);
    }

    // 删除
    @RequestMapping(value = "/del", method = {RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Boolean delLinkage(@RequestParam(value = "id") Integer id) {
        return linkagesService.delLinkage(id);
    }

    // 修改
    @RequestMapping(value = "/update", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public Linkage updateLinkage(@RequestBody Linkage linkage) {
        if (linkage.getName() == null && linkage.getLink() == null && linkage.getDescribe() == null) {
            return linkage;
        } else {
            return linkagesService.updateLinkage(linkage);
        }
    }

    // 分页查询
    @PostMapping(value = "/list")
    public Object findPage(@RequestBody PageRequest pageRequest) {
        return linkagesService.findPage(pageRequest);
    }
}
