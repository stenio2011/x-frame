package org.stenio.xframe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stenio.xframe.mapper.TestMapper;

/**
 * Created by bjhexin3 on 2017/6/6.
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private TestMapper testMapper;


    @RequestMapping("/test1")

    public String test1() {
        return "test1";
    }

    @RequestMapping("/test2")
    public int test2() {
        return testMapper.test2();
    }
}

