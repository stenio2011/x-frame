package org.stenio.xframe.mapper.demo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by bjhexin3 on 2017/6/6.
 */
@Mapper
public interface TestMapper {

    @Select("select 1 from dual")
    int test();

    int test2();

    @Select("select 1 from file_item")
    List<Integer> test3();
}
