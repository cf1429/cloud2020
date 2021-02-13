package test;

import java.time.ZonedDateTime;

public class test {
    public static void main(String[] args) {
        // 获取当前时区
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
}
