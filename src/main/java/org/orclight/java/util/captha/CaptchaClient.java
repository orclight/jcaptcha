package org.orclight.java.util.captha;

import org.orclight.java.util.captha.bean.CaptchaBean;
import org.orclight.java.util.captha.service.SimpleCaptchaService;
import org.orclight.java.util.captha.strategy.ICaptchaStrategy;
import org.orclight.java.util.captha.strategy.SimpleCaptchaStrategy;

import java.awt.*;

/**
 * Nothing seek, Nothing find.
 * author: shuzhilong
 * Date: 2017/9/26 下午2:52
 * desc: (The role of this class is to ...)
 * To change this template use preferences | editor | File and code Templates
 */
public class CaptchaClient {
    private SimpleCaptchaService simpleCaptchaService;

    private CaptchaClient(int width,int height,int lineNum,float yawp,Color color
            ,ICaptchaStrategy captchaStrategy,boolean transform) {
        this.simpleCaptchaService = new SimpleCaptchaService(width,height,
                lineNum,yawp,color,captchaStrategy,transform);
    }

    public CaptchaBean generate() {
        return simpleCaptchaService.generateCaptcha();
    }

    public static Builder create() {
        return new Builder();
    }

    public static final class Builder {
        private int width = 90;
        private int height = 30;
        private int lineNum = 2;
        private float yawp = 0.01f;
        Color color = new Color(253, 251, 255);
        ICaptchaStrategy captchaStrategy = new SimpleCaptchaStrategy();
        private boolean transform=false;

        public Builder width(int width) {
            this.width = width;
            return this;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Builder lineNum(int lineNum) {
            this.lineNum = lineNum;
            return this;
        }

        public Builder yawp(float yawp) {
            this.yawp = yawp;
            return this;
        }

        public Builder color(Color color) {
            this.color = color;
            return this;
        }

        public Builder transform(boolean transform) {
            this.transform = transform;
            return this;
        }

        public Builder captchaStrategy(ICaptchaStrategy captchaStrategy) {
            this.captchaStrategy = captchaStrategy;
            return this;
        }

        public CaptchaClient build() {
            return new CaptchaClient(width,height,lineNum,yawp,color,captchaStrategy,transform);
        }
    }
}
