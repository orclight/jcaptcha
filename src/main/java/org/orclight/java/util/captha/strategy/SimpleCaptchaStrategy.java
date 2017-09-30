package org.orclight.java.util.captha.strategy;

import org.orclight.java.util.captha.bean.CaptchaBean;

import java.util.Random;

/**
 * Nothing seek, Nothing find.
 * author: shuzhilong
 * Date: 2017/9/26 下午2:58
 * desc: (The role of this class is to ...)
 * To change this template use preferences | editor | File and code Templates
 */
public class SimpleCaptchaStrategy implements ICaptchaStrategy {
    private static char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    int codecnt=4;
    Random random = new Random();

    public SimpleCaptchaStrategy() {
    }

    public SimpleCaptchaStrategy(int codecnt) {
        this.codecnt = codecnt;
    }

    public CaptchaBean generateCode() {
        CaptchaBean captchaBean = new CaptchaBean();
        String[] codeArray = new String[codecnt];
        StringBuffer builder = new StringBuffer();
        for (int i = 0; i < codecnt; i++) {
            char c = ch[random.nextInt(ch.length)];
            String ch = String.valueOf(c);
            codeArray[i] = ch;
            builder.append(ch);
        }
        captchaBean.setCodeArray(codeArray);
        captchaBean.setResult(builder.toString());
        return captchaBean;
    }
}
