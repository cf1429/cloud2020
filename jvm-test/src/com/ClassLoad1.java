package com;

import sun.misc.Launcher;

import java.net.URL;

/**
 * @Author:chenf
 * @Date:2021/7/16 17:36
 * @describe
 */
public class ClassLoad1 {
    public static void main(String[] args) {
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassLoader = appClassLoader.getParent();
        ClassLoader bootstrapLoader = extClassLoader.getParent();
        System.out.println(appClassLoader);
        System.out.println(extClassLoader);
        System.out.println(bootstrapLoader);
        System.out.println("bootstrapLoader加载以下文件");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urLs.length; i++) {
            System.out.println(urLs[i]);
        }

        System.out.println("extClassloader加载以下文件：");
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println("appClassLoader加载以下文件：");
        System.out.println(System.getProperty("java.class.path"));
        Launcher launcher = Launcher.getLauncher();
        ClassLoader classLoader = launcher.getClassLoader();
        //classLoader.loadClass().equals()


    }
}
