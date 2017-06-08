package org.stenio.xframe.authentication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stenio.xframe.common.domain.ResponseWrapper;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hexinjs on 2017/6/9.
 */
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @RequestMapping("/redirect")
    public ResponseWrapper redirect(){
        return new ResponseWrapper<>(401, "user has not logged in", null);
    }

    @RequestMapping("/login")
    public ResponseWrapper<String> login(String username, String password, HttpSession httpSession){
        if("stenio".equals(username) && "stenio".equals(password)){
            SysUser sysUser = new SysUser();
            httpSession.setAttribute(SysUser.SESSION_SYS_USER_ATTRIBUTE, sysUser);
            SessionContextHolder.set(sysUser);
            return new ResponseWrapper<>(200, "login success", null);
        }
        return new ResponseWrapper<>(401, "username or password is invalid", null);
    }

    @RequestMapping("/logout")
    public ResponseWrapper<String> logout(HttpSession httpSession){
        httpSession.invalidate();
        return new ResponseWrapper<>(200, "logout success", null);
    }

}
