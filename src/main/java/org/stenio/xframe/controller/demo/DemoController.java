package org.stenio.xframe.controller.demo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stenio.xframe.common.domain.ResponseWrapper;
import org.stenio.xframe.mapper.demo.TestMapper;

import java.util.List;

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
    public ResponseWrapper test2() {
        return new ResponseWrapper(testMapper.test2());
    }

    @RequestMapping("/test3")
    public ResponseWrapper test3() {
        PageHelper.startPage(1000000, 10);
        List<Integer> integers = testMapper.test3();
        return new ResponseWrapper(new PageInfo<>(integers));
    }
}

