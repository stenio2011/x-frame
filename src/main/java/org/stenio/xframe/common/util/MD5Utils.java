package org.stenio.xframe.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stenio.xframe.common.exception.RuntimeXFrameException;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by bjhexin3 on 2017/6/8.
 */
public class MD5Utils {

    private static final Logger logger = LoggerFactory.getLogger(MD5Utils.class);

    private final static String[] strDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String encode(String str){

        //确定计算方法
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            //加密后的字符串
            byte[] digest = md5.digest(str.getBytes("UTF-8"));
            return byteToHexString(digest);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e ) {
            ExceptionUtil.logErrorAndThrow(logger, new RuntimeXFrameException(), "error to encode string : {}", str);
        }
        return null;

    }

    private static String byteToHexString(byte bt) {
        int iRet = bt;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    private static String byteToHexString(byte[] bts) {
        if (bts == null || bts.length == 0) {
            ExceptionUtil.logErrorAndThrow(logger, new RuntimeXFrameException("byte array is empty"), "byte array is empty");
        }
        StringBuilder sb = new StringBuilder();
        for (byte bt : bts) {
            sb.append(byteToHexString(bt));
        }
        return sb.toString();
    }
}
