package com.cf.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

public class TestAuthenticator {
    public static void main(String[] args) {
        //创建安全管理器对象
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();

        // 给安全管理器设置realm
        IniRealm realm = new IniRealm("classpath:shiro.ini");
        defaultSecurityManager.setRealm(realm);

        //SecurityUtils 给全局安全工具类设置安全管理器
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        // 关键对象 subject 主体
        Subject subject = SecurityUtils.getSubject();

        //创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken("xiaochen","123");
        try{
            System.out.println("认证状态："+subject.isAuthenticated());
            subject.login(token);   //用户认证
            System.out.println("认证状态："+subject.isAuthenticated());
        }catch (UnknownAccountException e){
            e.printStackTrace();
            System.out.println("用户不存在");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("用户密码不正确");

        }
        Realm realm1;




    }
}
