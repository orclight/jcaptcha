package org.orclight.java.util.captha.strategy;

import org.orclight.java.util.captha.bean.CaptchaBean;

import java.util.Random;

/**
 * Nothing seek, Nothing find.
 * author: shuzhilong
 * Date: 2017/9/26 下午3:03
 * desc: (The role of this class is to ...)
 * To change this template use preferences | editor | File and code Templates
 */
public class CalculateCaptchaStrategy implements ICaptchaStrategy {

    private int codecnt=4;

    public CalculateCaptchaStrategy() {
    }

    public CaptchaBean generateCode() {
        CaptchaBean captchaBean = new CaptchaBean();
        String[] codeArray = new String[codecnt];
        int result=0;

        char[] op = "+-".toCharArray();
        Random r = new Random();

        int firstNum = r.nextInt(100);
        codeArray[0] = String.valueOf(firstNum);

        int index = r.nextInt(2);
        char operation = op[index];
        codeArray[1] = String.valueOf(operation);

        int secondNum = r.nextInt(100);
        codeArray[2] = String.valueOf(secondNum);

        codeArray[3] = String.valueOf("=");

        if (operation == '+') {
            result = firstNum+secondNum;
        } else if (operation == '-') {
            result = firstNum-secondNum;
        }
//        else if (operation == '*') {
//            result = firstNum*secondNum;
//        }
        captchaBean.setCodeArray(codeArray);
        captchaBean.setResult(String.valueOf(result));
        return captchaBean;
    }

}
