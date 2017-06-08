package org.stenio.xframe.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stenio.xframe.common.exception.RuntimeXFrameException;

import java.io.IOException;

/**
 * Created by hexinjs on 2017/6/8.
 */
public class JsonUtils {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    private static final ObjectMapper om = new ObjectMapper();

    public static <T> String toJson(T t) {
        try {
            return om.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            ExceptionUtils.logErrorAndThrow(logger, new RuntimeXFrameException("fail to transform to json string"),
                    "fail to transform to json string!");
        }
        return null;
    }

    public static <T> T parse(String json, Class<T> clazz) {
        try {
            return om.readValue(json, clazz);
        } catch (IOException e) {
            ExceptionUtils.logErrorAndThrow(logger,
                    new RuntimeXFrameException("fail to parse to type : " + clazz.getName()),
                    "fail to parse to type : {}, json string : {}", clazz.getName(), json);
        }
        return null;
    }
}
