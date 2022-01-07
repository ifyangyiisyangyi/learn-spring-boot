package com.example.yang.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Linkage {
    private int id;
    private String name;
    @NotNull(message = "link不能为空")
    private String link;
    private String describe;
}
