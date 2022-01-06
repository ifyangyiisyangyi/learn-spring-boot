package com.example.yang.pojo;

import lombok.Data;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class Linkage {
    private int id;
    private String name;
    private String link;
    private String describe;
}
