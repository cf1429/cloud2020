package com.atguigu.springcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @Author:chenf
 * @Date:2021/6/21 23:02
 * @describe
 */
@Controller
@RequestMapping(value = "/captch")
public class CaptchController {
    // 图像宽度120像素
    private int width = 120;
    // 图像高度30像素
    private int height = 30;
    // 图片内容在图片的起始位置18像素
    private int drawY = 20;
    // 文字的间隔 18像素
    private int space = 15;
    // 验证码有几个文字
    private int charCount = 6;



    private String chars[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P",
            "Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p",
            "q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","9"};

    @GetMapping("/code")
    public void makeCaptchaCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
        /**
         * 验证码，需要在内存中绘制一个图片BufferedImage
         * 向这个图片中写入文字，把绘制好内容的图片响应
         */
        // 创建一个北京透明的图片，使用rgb表示颜色
        BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics g = image.getGraphics();

        //设置使用画笔是白色
        g.setColor(Color.white);

        // fillRect(矩形的起始x，矩形的起始y，矩形的宽度，矩形的宽度)
        g.fillRect(0,0,width,height);

        // 创建一个字体
        Font font = new Font("宋体",Font.BOLD,16);
        g.setFont(font);
        //设置字体颜色
        g.setColor(Color.BLACK);

        //在画布上写上内容
        /**
         * 参数，文字，x，y坐标
         */
        // g.drawString("中",10,drawY);  写一个
        StringBuilder builder = new StringBuilder();
        int ran = 0;
        int len = chars.length;
        for(int i=0; i<charCount;i++){
            ran = new Random().nextInt(len);
            builder.append(chars[ran]);
            g.setColor(makeColor());
            g.drawString(chars[ran],(i+1)*space,drawY);
        }

        for(int m =0 ;m<4;m++){
            g.setColor(makeColor());
            int[] ints = makeLineDot();
            g.drawLine(ints[0],ints[1],ints[2],ints[3]);
        }

        request.getSession().setAttribute("code",builder.toString());

        // 设置没有缓冲
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",0);
        response.setContentType("image/png");
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**
         * ReaderedImage im 输出图标
         * String formatName  图像格式，jpg，jpeg，png
         * ImageOutputStream output 输出到哪
         */
        ImageIO.write(image,"png",outputStream);
        outputStream.flush();
        outputStream.close();
    }


    private Color makeColor(){
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return new Color(r,g,b);
    }


    private int [] makeLineDot(){
        Random random = new Random();
        int x1 = random.nextInt(width/2);
        int y1 = random.nextInt(height);

        int x2 = random.nextInt(width);
        int y2 = random.nextInt(height);

        return new int[]{x1,y1,x2,y2};
    }

}
