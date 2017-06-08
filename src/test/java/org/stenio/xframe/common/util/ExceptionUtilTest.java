package org.stenio.xframe.common.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stenio.xframe.common.exception.RuntimeXFrameException;

/**
 * Created by bjhexin3 on 2017/6/8.
 */
public class ExceptionUtilTest {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionUtilTest.class);

    @Test
    public void logErrorAndThrow() throws Exception {
    }

    @Test
    public void logErrorAndThrow1() throws Exception {
        try {
            ExceptionUtils.logErrorAndThrow(logger, new RuntimeXFrameException("heihei"), "message", "abc");
        } catch (Exception e) {

        }
    }

    @Test
    public void logInfoAndThrow() throws Exception {
    }

}