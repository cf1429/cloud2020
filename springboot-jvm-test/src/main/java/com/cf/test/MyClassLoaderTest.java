package com.cf.test;

import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author:chenf
 * @Date:2021/7/19 18:18
 * @describe
 */
public class MyClassLoaderTest {
    static class MyClassLoader extends ClassLoader{
        private String classPath;

        public MyClassLoader(String classPath){
            this.classPath = classPath;
        }

        private byte[] loadBy(String name) throws Exception{
            name = name.replaceAll("\\."," ");
            FileInputStream fis = new FileInputStream(classPath+"/"+name+".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] bytes = loadBy(name);
                return defineClass(name,bytes,0, bytes.length);

            } catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }


        public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
            MyClassLoader classLoader = new MyClassLoader("E:\\test");
            Class aClass = classLoader.loadClass("com.cf.User");
            Object o = aClass.newInstance();
            Method m = aClass.getMethod("sout", null);
            Object invoke = m.invoke(o, null);
            System.out.println(aClass.getClassLoader().getClass().getName());


        }
    }


}
