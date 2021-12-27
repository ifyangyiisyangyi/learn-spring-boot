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
    public Linkage addLinkage(@RequestParam(value = "name", required = true) String name,
                              @RequestParam(value = "link", required = true) String link,
                              @RequestParam(value = "describe", required = true) String describe) {
        Linkage linkage = new Linkage();
        linkage.setName(name);
        linkage.setLink(link);
        linkage.setDescribe(describe);
        linkagesService.addLinkage(linkage);
        return linkage;
    }
    // 删除

    // 修改
}
