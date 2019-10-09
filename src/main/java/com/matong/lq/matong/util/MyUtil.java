package com.matong.lq.matong.util;

import java.util.Random;

/**
 * @Description
 * @Author LiuQiang
 * @Date 2019/9/29 10:05
 * @Version 1.0
 */
public class MyUtil {
    public static String getRandomChar(int length) {            //生成随机字符串
        char[] chr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                '1', '2', '4', '6', '8'};
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            buffer.append(chr[random.nextInt(36)]);
        }
        return buffer.toString();
    }
}
