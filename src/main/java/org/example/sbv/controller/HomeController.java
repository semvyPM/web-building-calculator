package org.example.sbv.controller;

import org.example.sbv.MyData;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.List;

@RestController
public class HomeController {

    @GetMapping("/get") public String home() {
        return "This is the get request";
    }

    @GetMapping("/data")
    @ResponseBody
    public MyData getData() {
        MyData data = new MyData("example");
        return data;
    }

    @GetMapping("/data/items")
    @ResponseBody
    public List<MyData> getDataItems() {
        return Arrays.asList(new MyData(1,"Vasya"), new MyData(2,"Ivan"), new MyData(3,"Aleksey"));
    }

}
