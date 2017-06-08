package org.stenio.xframe.common.util;

import org.slf4j.Logger;
import org.stenio.xframe.common.exception.RuntimeXFrameException;
import org.stenio.xframe.common.exception.XFrameException;

/**
 * Created by bjhexin3 on 2017/6/8.
 */
public class ExceptionUtils {

    public static void logErrorAndThrow(Logger logger, RuntimeXFrameException runtimeXFrameException, String message, Object... objects) {
        logger.error(message, objects);
        throw runtimeXFrameException;
    }

    public static void logErrorAndThrow(Logger logger, XFrameException xFrameException, String message, Object... objects) throws XFrameException {
        logger.error(message, objects);
        throw xFrameException;
    }

    public static void logInfoAndThrow(Logger logger, String message, Throwable throwable) {

    }
}
