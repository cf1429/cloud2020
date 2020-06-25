package com.atguigu.springcloud.config;

import cn.hutool.core.util.StrUtil;
import com.atguigu.springcloud.entities.User;
import com.atguigu.springcloud.RedisServie;
import org.springframework.lang.Nullable;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cf
 * @create 2020\4\28 0028
 */
public class AuthInterceptor implements HandlerInterceptor {

    private RedisServie redisServie;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        if("OPTIONS".equals(request.getMethod().toUpperCase())){
            return true;
        }
        String token = this.getAuthToken(request);
        if(StrUtil.isBlank(token)){
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }else{
            redisServie = this.getRedisUtil(RedisServie.class,request);
            User user = (User) redisServie.get(token);
            if(user != null ){
                return true;
            }else{
                return false;
            }

        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

    // 获取token
    private String getAuthToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        if (token == null) {
            token = request.getParameter("token");
        }
        return token;
    }

    private <T> T getRedisUtil(Class<T> clazz, HttpServletRequest request){
        WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return applicationContext.getBean(clazz);
    }


}
