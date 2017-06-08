package org.stenio.xframe.controller.demo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stenio.xframe.common.domain.ResponseWrapper;
import org.stenio.xframe.common.exception.RuntimeXFrameException;
import org.stenio.xframe.common.util.ExceptionUtil;
import org.stenio.xframe.mapper.demo.FileItemMapper;
import org.stenio.xframe.mapper.demo.TestMapper;
import org.stenio.xframe.model.demo.FileItem;
import org.stenio.xframe.model.demo.FileItemExample;

import java.util.List;

/**
 * Created by bjhexin3 on 2017/6/6.
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    @Autowired
    private TestMapper testMapper;
    @Autowired
    private FileItemMapper fileItemMapper;

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

    @RequestMapping("/test4")
    public ResponseWrapper test4() {
        ExceptionUtil.logErrorAndThrow(logger, new RuntimeXFrameException("heihei"), "message, {}, xxxs {}", "abc", "def");
        FileItemExample query = new FileItemExample();
        query.createCriteria().andDirEqualTo("/");
        List<FileItem> fileItems = fileItemMapper.selectByExample(query);
        return new ResponseWrapper(fileItems);
    }
}

