package org.stenio.xframe.common.util;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stenio.xframe.common.exception.RuntimeXFrameException;
import org.stenio.xframe.common.http.HttpEntity;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bjhexin3 on 2017/6/13.
 */
public class HttpUtil {


    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static HttpEntity.ResponseEntity getForEntity(String url) {
        return getForEntity(url, null);
    }

    public static HttpEntity.ResponseEntity getForEntity(String url, Map<String, String> headers) {
        return getForEntity(url, headers, null);
    }

    public static HttpEntity.ResponseEntity getForEntity(String url, Map<String, String> headers, Map<String, Object> params) {
        HttpGet httpGet = new HttpGet();
        if (!CollectionUtils.isEmpty(headers)) {
            for (String headerName : headers.keySet()) {
                httpGet.setHeader(headerName, headers.get(headerName));
            }
        }

        URI uri = buildUrl(url, params);
        httpGet.setURI(uri);
        return invoke(httpGet);
    }

    public static  <T> T getForObject(String url, Class<T> responseType) {
        return getForObject(url, null, responseType);
    }

    public static <T> T getForObject(String url, Map<String, String> headers, Class<T> responseType) {
        return getForObject(url, headers, null, responseType);
    }

    public static <T> T getForObject(String url, Map<String, String> headers, Map<String, Object> params, Class<T> responseType) {
        HttpEntity.ResponseEntity responseEntity = getForEntity(url, headers, params);
        if (responseEntity.getStatusCode() == 200) {
            if (String.class.equals(responseType)) {
                return (T) responseEntity.getBody();
            }
            return JsonUtils.parse(responseEntity.getBody(), responseType);
        }
        logger.error("error status code, statusCode --> {}, url --> {}", responseEntity.getStatusCode(), url);
        return null;
    }

    private static URI buildUrl(String url, Map<String, Object> params) {
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            if (!CollectionUtils.isEmpty(params)) {
                for (String paramName : params.keySet()) {
                    Object valueObj = params.get(paramName);
                    if (!StringUtils.isEmpty(paramName) && valueObj != null) {
                        uriBuilder.setParameter(paramName, valueObj.toString());
                    }
                }
            }
            return uriBuilder.build();
        } catch (URISyntaxException e) {

            ExceptionUtils.logErrorAndThrow(logger, new RuntimeXFrameException("url syntax is error"), "url syntax is error, url : {}", url);
        }
        return null;
    }

    private static HttpEntity.ResponseEntity invoke(HttpUriRequest request) {
        HttpResponse httpResponse = sendRequest(request);
        HttpEntity.ResponseEntity responseEntity = parseResponse(httpResponse);
        return responseEntity;
    }

    private static HttpEntity.ResponseEntity parseResponse(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        Map<String, String> headers = new HashMap<>();
        if (httpResponse.getAllHeaders() != null) {
            for (Header header : httpResponse.getAllHeaders()) {
                headers.put(header.getName(), header.getValue());
            }
        }
        String body = null;
        try {
            body = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        } catch (IOException e) {
            ExceptionUtils.logErrorAndThrow(logger, new RuntimeXFrameException("exception occurs on parsing response to string."), "exception occurs on parsing response to string.");
        }
        return new HttpEntity.ResponseEntity(headers, body, statusCode);
    }

    private static HttpResponse sendRequest(HttpUriRequest request) {
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(request);
        } catch (IOException e) {
            ExceptionUtils.logErrorAndThrow(logger, new RuntimeXFrameException("exception occurs on sending request."), "exception occurs on sending request.");
        }
        return response;
    }

}
