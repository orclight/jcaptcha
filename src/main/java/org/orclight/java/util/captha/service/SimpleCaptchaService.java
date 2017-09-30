package org.orclight.java.util.captha.service;

import org.orclight.java.util.captha.strategy.ICaptchaStrategy;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Nothing seek, Nothing find.
 * author: shuzhilong
 * Date: 2017/9/26 下午4:33
 * desc: (The role of this class is to ...)
 * To change this template use preferences | editor | File and code Templates
 */
public class SimpleCaptchaService extends AbstractCaptchaService {

    public SimpleCaptchaService(int width, int height, int linNum,float yawp,
                                Color color, ICaptchaStrategy captchaStrategy,boolean transform) {
        this.width = width;
        this.height = height;
        this.lineNum = linNum;
        this.yawp = yawp;
        this.color = color;
        this.transform = transform;
        this.captchaStrategy = captchaStrategy;
    }

    @Override
    public void drawOther(BufferedImage image) {
        //do something
    }
}
