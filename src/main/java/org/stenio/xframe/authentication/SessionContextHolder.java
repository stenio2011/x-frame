package org.stenio.xframe.authentication;

/**
 * Created by hexinjs on 2017/6/8.
 */
public class SessionContextHolder {

    private static final ThreadLocal<SysUser> local = new ThreadLocal<>();

    public static SysUser get() {
        return local.get();
    }

    public static void set(SysUser sysUser) {
        local.set(sysUser);
    }

}
