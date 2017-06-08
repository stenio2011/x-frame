package org.stenio.xframe.common.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bjhexin3 on 2017/6/8.
 */
public class MD5UtilsTest {
    @Test
    public void encode() throws Exception {
        String str = MD5Utils.encode("123456");
        assertEquals(str, "e10adc3949ba59abbe56e057f20f883e");
    }

}