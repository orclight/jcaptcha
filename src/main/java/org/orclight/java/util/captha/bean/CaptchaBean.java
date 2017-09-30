package org.orclight.java.util.captha.bean;

import java.awt.image.BufferedImage;

/**
 * Nothing seek, Nothing find.
 * author: shuzhilong
 * Date: 2017/9/26 下午3:34
 * desc: (The role of this class is to ...)
 * To change this template use preferences | editor | File and code Templates
 */
public class CaptchaBean {

    private String result;
    private String[] codeArray;
    private BufferedImage bufferedImage;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String[] getCodeArray() {
        return codeArray;
    }

    public void setCodeArray(String[] codeArray) {
        this.codeArray = codeArray;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }
}
