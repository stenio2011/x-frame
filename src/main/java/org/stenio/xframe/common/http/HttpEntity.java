package org.stenio.xframe.common.http;

import java.util.Map;

/**
 * Created by bjhexin3 on 2017/6/13.
 */
public class HttpEntity {

    private Map<String, String> headers;

    private String body;

    public HttpEntity() {
    }

    public HttpEntity(Map<String, String> headers, String body) {
        this.headers = headers;
        this.body = body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Created by bjhexin3 on 2017/6/13.
     */
    public static class ResponseEntity extends HttpEntity {

        private Integer statusCode;

        public ResponseEntity(int statusCode) {
            this(null, null, statusCode);
        }

        public ResponseEntity(Map<String, String> headers, String body, int statusCode) {
            super(headers, body);
            this.statusCode = statusCode;
        }

        public Integer getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(Integer statusCode) {
            this.statusCode = statusCode;
        }
    }
}
