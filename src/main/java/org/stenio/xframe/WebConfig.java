package org.stenio.xframe;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.stenio.xframe.authentication.AuthenticationInterceptor;

/**
 * Created by bjhexin3 on 2017/6/7.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    public void addInterceptors(InterceptorRegistry registry) {
        AuthenticationInterceptor authenticationInterceptor = new AuthenticationInterceptor();
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/**");
    }
}
