package org.orclight.java.util.captha.service;

import org.orclight.java.util.captha.bean.CaptchaBean;
import org.orclight.java.util.captha.strategy.ICaptchaStrategy;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Nothing seek, Nothing find.
 * author: shuzhilong
 * Date: 2017/9/26 下午3:17
 * desc: (The role of this class is to ...)
 * To change this template use preferences | editor | File and code Templates
 */
public abstract class AbstractCaptchaService implements ICaptchaService {

    Random random = new Random();
    ICaptchaStrategy captchaStrategy;

    int width = 90;
    int height = 30;
    int lineNum = 2;
    float yawp = 0.01f;
    Color color = new Color(253, 251, 255);
    boolean transform=false;

    public CaptchaBean generateCaptcha() {
        // 1.build image
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(color);
//        graphics.setColor(getRandColor(200, 250));
        graphics.fillRect(0, 0, width, height);

        //2.mixSource
        mixSource(image);

        //3.drawCode
        CaptchaBean result = drawCode(graphics);
        result.setBufferedImage(image);
        return result;
    }

    public void mixSource(BufferedImage image) {
        drawPoint(image);
        drawLine(image);
        drawOther(image);
    }

    public void drawLine(BufferedImage image) {
        Graphics graphics = image.getGraphics();
        for (int i = 0; i < lineNum; i++) {
            int xs = random.nextInt(width);
            int ys = random.nextInt(height);
            int xe = xs + random.nextInt(width);
            int ye = ys + random.nextInt(height);
            graphics.setColor(getRandColor(1, 255));
            graphics.drawLine(xs, ys, xe, ye);
        }
    }

    public void drawPoint(BufferedImage image) {
        // 添加噪点
        float yawpRate = 0.05f;// 噪声率
        int area = (int) (yawpRate * width * height);
        for (int i = 0; i < area; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            image.setRGB(x, y, random.nextInt(255));
        }
    }

    public abstract void drawOther(BufferedImage image);

    public CaptchaBean drawCode(Graphics graphics) {
        //1.genarate code
        CaptchaBean captcha = captchaStrategy.generateCode();

        //2.drapCode
        Font font = getFont(16);
        graphics.setFont(font);
        if(captcha!=null&&captcha.getCodeArray()!=null
                &&captcha.getResult()!=null&&captcha.getCodeArray().length>0) {
            for(int i=0;i<captcha.getCodeArray().length;i++) {
                String code = String.valueOf(captcha.getCodeArray()[i]);

                // 文字变形设置
                if(transform) {
                    AffineTransform fontAT = new AffineTransform();
                    int rotate = random.nextInt(25);
                    fontAT.rotate(random.nextBoolean() ? Math.toRadians(rotate) : -Math
                            .toRadians(rotate / 2));
                    Font fx = new Font(new String[] { "Times New Roman", "Verdana",
                            "arial" }[random.nextInt(2)], random.nextInt(5),
                            14 + random.nextInt(8)).deriveFont(fontAT);
                    graphics.setFont(fx);
                }

                // 产生随机的颜色分量来构造颜色值，这样输出的每一位数字的颜色值都不同
//                int red = random.nextInt(255);
//                int green = random.nextInt(255);
//                int blue = random.nextInt(255);
                // 将随机产生的颜色将验证码绘制到图像中
                graphics.setColor(getRandColor(1, 255));
//                graphics.drawString(code, (i*20)+5, 10+random.nextInt(10));
                graphics.drawString(code, (i*width/5)+5, height/2+ random.nextInt(height/4));
            }
        }
        return captcha;
    }

    // 得到随机颜色
    public Color getRandColor(int fc, int bc) {// 给定范围获得随机颜色
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    private Font getFont(int size) {
        Random random = new Random();
        Font font[] = new Font[5];
        font[0] = new Font("Ravie", Font.BOLD, size);
        font[1] = new Font("Antique Olive Compact", Font.BOLD, size);
        font[2] = new Font("Fixedsys", Font.BOLD, size);
        font[3] = new Font("Wide Latin", Font.BOLD, size);
        font[4] = new Font("Gill Sans Ultra Bold", Font.BOLD, size);
        return font[random.nextInt(5)];
    }

    public void setCaptchaStrategy(ICaptchaStrategy captchaStrategy) {
        this.captchaStrategy = captchaStrategy;
    }
}
