package org.stenio.xframe.controller.demo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.stenio.xframe.common.domain.ResponseWrapper;
import org.stenio.xframe.common.exception.RuntimeXFrameException;
import org.stenio.xframe.common.util.ExceptionUtils;
import org.stenio.xframe.mapper.demo.FileItemMapper;
import org.stenio.xframe.mapper.demo.TestMapper;
import org.stenio.xframe.model.demo.FileItem;
import org.stenio.xframe.model.demo.FileItemExample;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
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
    @Autowired
    private RestTemplate restTemplate;

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
        ExceptionUtils.logErrorAndThrow(logger, new RuntimeXFrameException("heihei"), "message, {}, xxxs {}", "abc", "def");
        FileItemExample query = new FileItemExample();
        query.createCriteria().andDirEqualTo("/");
        List<FileItem> fileItems = fileItemMapper.selectByExample(query);
        return new ResponseWrapper(fileItems);
    }

    @RequestMapping("/test5")
    public ResponseWrapper<String> test5() {

        String body = null;

        try {
            ResponseEntity<String> entity = restTemplate.getForEntity(new URI("https://www.baidu.com"), String.class);
            body = entity.getBody();
            body = new String(body.getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new ResponseWrapper<>(body);
    }

}

