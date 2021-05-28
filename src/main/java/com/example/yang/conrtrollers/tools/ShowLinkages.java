package com.example.yang.conrtrollers.tools;

import com.example.yang.pojo.Linkage;
import com.example.yang.service.LinkagesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ShowLinkages {
    @Resource
    LinkagesService linkagesService;

    @RequestMapping(value = "/linkages", method = {RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public List<Linkage> showLinkages() {
        return linkagesService.getLinkages();

    }
}
