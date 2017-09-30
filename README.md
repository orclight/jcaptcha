# jcaptcha
java验证码工具类，可选择英文验证码，中文验证码，算术验证码等策略

一.功能描述
  1.1 支持生成三种策略的验证码：字母验证码，中文验证码，算术验证码
  1.2 可设置验证码图片尺寸，背景色
  1.3 可设置干扰项：干扰线条，干扰噪点

二.效果图




三.实例代码

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
 * author: shuzhilong
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
        getSimple("/Users/shuzhilong/Documents/temp/SimpleCaptchaStrategy.jpg");
        getChinese("/Users/shuzhilong/Documents/temp/ChineseCaptchaStrategy.jpg");
        getCalculate("/Users/shuzhilong/Documents/temp/CalculateCaptchaStrategy.jpg");
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
