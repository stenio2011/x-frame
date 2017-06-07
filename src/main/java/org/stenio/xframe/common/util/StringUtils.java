package org.stenio.xframe.common.util;

/**
 * Created by bjhexin3 on 2017/6/7.
 */
public class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null ? true : str.length() == 0;
    }

    public static boolean isBlank(String str) {
        return isEmpty(str) ? true : str.trim().length() == 0;
    }

    public static boolean isNumberString(String str) {
        return isNumberString(str, false);
    }
    
    public static boolean isNumberString(String str, boolean allowComma) {
        if (isBlank(str)) {
            return false;
        }
        char[] chars = str.toCharArray();
        int dotCount = 0;
        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                continue;
            }
            if (c == '.') {
                if (++dotCount > 1) {
                    return false;
                }
                continue;
            }
            if (allowComma && c == ',') {
                // 此处未校验逗号格式为每三位一个逗号。
                continue;
            }
        }

        return true;
    }

}
