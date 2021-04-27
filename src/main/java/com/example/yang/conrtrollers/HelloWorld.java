package com.example.yang.conrtrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: yy
 * date: 2021年4月24日
 */
@RestController
@RequestMapping("/hello")
public class HelloWorld {
    @RequestMapping("/world")
    public String sayHi() {
        testAutoBox();
        return "hello world";
    }

    public void testAutoBox(){

        /*
        进行 = 赋值操作（装箱或拆箱）
        进行+，-，*，/混合运算 （拆箱）
        进行>,<,==比较运算（拆箱）
        调用equals进行比较（装箱）
        ArrayList,HashMap等集合类 添加基础类型数据时（装箱）
         */


        // case1: 基础类型a与包装类b进行==比较，这时b会拆箱，直接比较值，所以会打印true
        int a = 100;
        Integer b = 100;
        System.out.println(a == b);

        // case2:二个包装类型，都被赋值了100，这时会进行装箱，调用Integer的valueOf方法，生成2个Integer对象，引用类型==比较，直接比较对象指针，这里我们先给出结论，最后会分析原因，打印 true
        Integer c = 100;
        Integer d = 100;
        System.out.println(c == d);

        //case3:跟上面第2段代码类似，只不过赋值变成了200，打印 false
        c = 200;
        d = 200;
        System.out.println(c == d);
    }
}

