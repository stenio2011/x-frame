package org.stenio.xframe.common.exception;

/**
 * Created by bjhexin3 on 2017/6/7.
 * <p>
 * x-frame runtime exception
 *
 * @see java.lang.RuntimeException
 */
public class RuntimeXFrameException extends RuntimeException {

    public RuntimeXFrameException() {
        super();
    }

    public RuntimeXFrameException(String message) {
        super(message);
    }

    public RuntimeXFrameException(String message, Throwable cause) {
        super(message, cause);
    }

    public RuntimeXFrameException(Throwable cause) {
        super(cause);
    }
}
