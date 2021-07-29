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
            name = name.replace(".","\\");
            System.out.println(classPath+"\\"+name+".class");
            FileInputStream fis = new FileInputStream(classPath+"\\"+name+".class");
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


        protected Class<?> loadClass(String name, boolean resolve)
                throws ClassNotFoundException
        {
            synchronized (getClassLoadingLock(name)) {
                // First, check if the class has already been loaded
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    long t0 = System.nanoTime();
//                    try {
//                        if (parent != null) {
//                            c = parent.loadClass(name, false);
//                        } else {
//                            c = findBootstrapClassOrNull(name);
//                        }
//                    } catch (ClassNotFoundException e) {
//                        // ClassNotFoundException thrown if class not found
//                        // from the non-null parent class loader
//                    }

                    if (c == null) {
                        // If still not found, then invoke findClass in order
                        // to find the class.
                        long t1 = System.nanoTime();
                        if(!name.startsWith("com.cf")){
                            c = this.getParent().loadClass(name);
                        }else{
                            c = findClass(name);
                        }

                        // this is the defining class loader; record the stats
                        sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                        sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                        sun.misc.PerfCounter.getFindClasses().increment();
                    }
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }










        public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
            MyClassLoader classLoader = new MyClassLoader("E:\\test");
            Class aClass = classLoader.loadClass("com.cf.test.User");
            Object o = aClass.newInstance();
            Method m = aClass.getMethod("sout", null);
            Object invoke = m.invoke(o, null);
            System.out.println(aClass.getClassLoader().getClass().getName());

            MyClassLoader classLoader1 = new MyClassLoader("E:\\test1");
            Class aClass1 = classLoader1.loadClass("com.cf.test.User");
            Object o1 = aClass1.newInstance();
            Method m1 = aClass1.getMethod("sout", null);
            Object invoke1 = m1.invoke(o1, null);
            System.out.println(aClass1.getClassLoader().getClass().getName());
        }
    }


}
