# jcaptcha
java验证码工具类，可选择英文验证码，中文验证码，算术验证码等策略


一.功能概述

  1.1 支持策略：字母验证码，中文验证码，算术验证码
  
  1.2 可配置:验证码图片尺寸，背景色
  
  1.3 可配置：干扰项：干扰线条，干扰噪点
  

二.效果图

2.1 字母验证码

![image](https://github.com/orclight/jcaptcha/blob/master/image/SimpleCaptchaStrategy.jpg)

2.2 中文验证码

![image](https://github.com/orclight/jcaptcha/blob/master/image/ChineseCaptchaStrategy.jpg)

3.2 算术验证码

![image](https://github.com/orclight/jcaptcha/blob/master/image/CalculateCaptchaStrategy.jpg)


三.实例代码

```java 
import org.orclight.java.util.captha.CaptchaClient;
import org.orclight.java.util.captha.bean.CaptchaBean;
import org.orclight.java.util.captha.strategy.CalculateCaptchaStrategy;
import org.orclight.java.util.captha.strategy.ChineseCaptchaStrategy;
import org.orclight.java.util.captha.strategy.SimpleCaptchaStrategy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Nothing seek, Nothing find.
 * author: orclight
 * Date: 2017/9/26 下午5:05
 * desc: (The role of this class is to ...)
 * To change this template use preferences | editor | File and code Templates
 */
public class TestCaptchaClient {

    static CaptchaClient simpleCaptchaClient = null;
    static CaptchaClient chineseCaptchaClient = null;
    static CaptchaClient calculateCaptchaClient = null;


    static {
        simpleCaptchaClient = CaptchaClient.create().
                            captchaStrategy(new SimpleCaptchaStrategy())
                            .build();
        chineseCaptchaClient = CaptchaClient.create()
                        .captchaStrategy(new ChineseCaptchaStrategy())
                        .build();

        calculateCaptchaClient = CaptchaClient.create()
                        .width(68)
                        .height(22)
                        .lineNum(2)
                        .yawp(0.01f)
                        .captchaStrategy(new CalculateCaptchaStrategy())
                        .transform(true)
                        .color(new Color(253, 251, 255))
                        .build();
    }

    public static void main(String[] args) {
        getSimple("/Users/yourpath/SimpleCaptchaStrategy.jpg");
        getChinese("/Users/yourpath/ChineseCaptchaStrategy.jpg");
        getCalculate("/Users/yourpath/CalculateCaptchaStrategy.jpg");
    }

    public static void getSimple(String filepath) {
        CaptchaBean captchaBean = simpleCaptchaClient.generate();

        File file = new File(filepath);
        try {
            file.createNewFile();
            ImageIO.write(captchaBean.getBufferedImage(), "JPG", file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(captchaBean.getResult());

    }

    public static void getChinese(String filepath) {
        CaptchaBean captchaBean = chineseCaptchaClient.generate();

        File file = new File(filepath);
        try {
            file.createNewFile();
            ImageIO.write(captchaBean.getBufferedImage(), "JPG", file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(captchaBean.getResult());

    }

    public static void getCalculate(String filepath) {
        CaptchaBean captchaBean = calculateCaptchaClient.generate();

        File file = new File(filepath);
        try {
            file.createNewFile();
            ImageIO.write(captchaBean.getBufferedImage(), "JPG", file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(captchaBean.getResult());

    }
}
