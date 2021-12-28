package com.example.yang.conrtrollers.tools;

import com.example.yang.pojo.Linkage;
import com.example.yang.service.LinkagesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
    public Boolean delLinkage(@RequestParam(value = "id", required = true) Integer id){
        return linkagesService.delLinkage(id);
    }
    // 修改
    @RequestMapping(value = "/update", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public Linkage updateLinkage(@RequestParam(value = "id", required = true) Integer id,
                                 @RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "link", required = false) String link,
                                 @RequestParam(value = "describe", required = false) String describe){
        Linkage linkage = new Linkage();
        linkage.setId(id);
        linkage.setName(name);
        linkage.setLink(link);
        linkage.setDescribe(describe);
        if (linkage.getName() == null && linkage.getLink() == null && linkage.getDescribe() == null) {
            return linkage;
        }
        else {
            return linkagesService.updateLinkage(linkage);
        }
    }
}
