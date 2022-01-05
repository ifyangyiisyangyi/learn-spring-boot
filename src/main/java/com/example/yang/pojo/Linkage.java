package com.example.yang.pojo;

import lombok.Data;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class Linkage {
//    @NotNull(message = "ID不能为空")
    private int id;
    private String name;
    private String link;
    private String describe;
}
