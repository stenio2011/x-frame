package org.stenio.xframe.authentication;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bjhexin3 on 2017/6/7.
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    private static final String[] WHITE_LIST = new String[]{"/authentication/redirect", "/authentication/login"};

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
//        String requestURI = httpServletRequest.getRequestURI();
//        System.out.print(requestURI);
//        List<String> whiteUrlList = Arrays.asList(WHITE_LIST);
//        if (whiteUrlList.contains(requestURI)) {
//            return true;
//        }
//        Object userObj = httpServletRequest.getSession().getAttribute(SysUser.SESSION_SYS_USER_ATTRIBUTE);
//        if (userObj != null) {
//            SysUser sysUser = (SysUser) userObj;
//            SessionContextHolder.set(sysUser);
//            return true;
//        } else {
//            httpServletRequest.getRequestDispatcher("/authentication/redirect").forward(httpServletRequest, httpServletResponse);
//            return false;
//        }
    }

}
