package com.example.yang.service;


import com.example.yang.pojo.Linkage;

import java.util.List;

public interface LinkagesService {
    List<Linkage> getLinkages();
    Linkage addLinkage(Linkage linkage);
    Boolean delLinkage(Integer id);
    Linkage updateLinkage(Linkage linkage);
}
