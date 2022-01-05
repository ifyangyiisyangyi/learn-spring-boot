package com.example.yang.conrtrollers.tools;

import com.example.yang.pojo.Linkage;
import com.example.yang.service.LinkagesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/linkage")
public class ShowLinkages {
    @Resource
    LinkagesService linkagesService;

    // 列表
    @RequestMapping(value = "/list", method = {RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public List<Linkage> showLinkages() {
        return linkagesService.getLinkages();

    }

    // 新增
    @RequestMapping(value = "/add", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public Boolean addLinkage(@RequestParam(value = "name", required = true) String name,
                              @RequestParam(value = "link", required = true) String link,
                              @RequestParam(value = "describe", required = true) String describe) {
        Linkage linkage = new Linkage();
        linkage.setName(name);
        linkage.setLink(link);
        linkage.setDescribe(describe);
        return linkagesService.addLinkage(linkage);
    }

    // 删除
    @RequestMapping(value = "/del", method = {RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Boolean delLinkage(@RequestParam(value = "id", required = true) Integer id) {
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
}
