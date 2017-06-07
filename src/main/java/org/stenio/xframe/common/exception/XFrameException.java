package org.stenio.xframe.common.exception;

/**
 * Created by bjhexin3 on 2017/6/7.
 * <p>
 * x-frame exception
 *
 * @see java.lang.Exception
 */
public class XFrameException extends Exception {

    public XFrameException() {
        super();
    }

    public XFrameException(String message) {
        super(message);
    }

    public XFrameException(String message, Throwable cause) {
        super(message, cause);
    }

    public XFrameException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     * @see Exception
     */
    protected XFrameException(String message, Throwable cause,
                              boolean enableSuppression,
                              boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
