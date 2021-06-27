package com.atguigu.springcloud.filter;

import com.atguigu.springcloud.common.MyFailureHandler;
import com.atguigu.springcloud.common.VerificationException;
import com.atguigu.springcloud.vo.Result;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author:chenf
 * @Date:2021/6/27 16:02
 * @describe
 */
public class VerificationCodeFilter extends OncePerRequestFilter {
    private MyFailureHandler failureHandler = new MyFailureHandler();

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("执行VerificationCodeFilter  doFilterInternal");
        // 只有是login操作，才需要这个过滤器参与验证码的使用
        String uri = httpServletRequest.getRequestURI();
        if(!"/login".equals(uri)){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }else{
            try {
            // 验证：code是否正确
            verifcatioinCode(httpServletRequest);
            // 如果验证通过，过滤器正常执行
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            }catch (VerificationException e){
                Result result = new Result();
                result.setCode(1);
                result.setError(1002);
                result.setMsg("验证码错误");
                failureHandler.setResult(result);
                failureHandler.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);

            }
        }
    }

    private void verifcatioinCode(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        // 获取请求中的验证码
        String code = httpServletRequest.getParameter("code");
        // 获取session中的验证码
        Object attr = session.getAttribute("code");
        String  sessionCode = "";
        if(attr != null ){
            sessionCode = (String) attr;
        }
        System.out.println("执行VerificationCodeFilter  doFilterInternal requestCode="+code+"|| sessionCode="+sessionCode);

        // 处理逻辑
        if(!StringUtils.isEmpty(sessionCode)){
            // 在session 中的有code，用户看到这个code了
            // 如果能到这段代码，说明用户已经发起了登录请求的
            // session中的现在的这个code便无用了
            session.removeAttribute("code");
        }

        // 判断验证码是否code
        if (StringUtils.isEmpty(code) || StringUtils.isEmpty(sessionCode) || !code.equals(sessionCode)){
            //失败
            throw new VerificationException();

        }
    }
}
