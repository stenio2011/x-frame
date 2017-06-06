package org.stenio.xframe.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by bjhexin3 on 2017/6/6.
 */
@Mapper
public interface TestMapper {

    @Select("select 1 from dual")
    int test();

    int test2();
}
