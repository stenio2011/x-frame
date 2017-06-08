package org.stenio.xframe.authentication;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by bjhexin3 on 2017/6/7.
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    private static final String SESSION_SYS_USER_ATTRIBUTE = "org.stenio.xframe.authentication.SysUser";

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Object userObj = httpServletRequest.getSession().getAttribute(SESSION_SYS_USER_ATTRIBUTE);
        if (userObj != null) {

            SysUser sysUser = (SysUser) userObj;
            SessionContextHolder.set(sysUser);
            return true;
        }
        else {

            return false;
        }
    }

}
