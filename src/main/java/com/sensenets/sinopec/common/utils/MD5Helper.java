/**
 * Copyright: Copyright (c) 2016 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author xupengtao
 * @date 2016年6月16日 上午11:30:42
 * @version V1.0
 */
package com.sensenets.sinopec.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/**
 * 
 * @author summer
 *
 */
public class MD5Helper {


    /**
      * @Fields hexDigits : 数字字母
      */
    private static char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    /**
     * @Title: toMD5
     * @Description: MD5加密
     * @param s
     *            明文
     * @return 密文
     */
    public static final String toMD5(String s) {
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = HEX_DIGITS[byte0 >>> 4 & 0xf];
                str[k++] = HEX_DIGITS[byte0 & 0xf];
            }
            return new String(str).toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

   
    /**
      * @Title: getFileMD5
      * @Description: 获取文件的MD5
      * @param file 文件
      * @return md5值
      */
    public static String getFileMD5(File file){
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            FileChannel ch = in.getChannel();
            MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(byteBuffer);
            in.close();
            return bufferToHex(mdInst.digest());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
      * @Title: bufferToHex
      * @Description: 字节数组转成16进制字符串
      * @param bytes 字节数组
      * @return 16进制
      */
    private static String bufferToHex(byte[] bytes) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    /**
     * @Title: bufferToHex
     * @Description: 字节数组转成16进制字符串
     * @param bytes 字节数组
     * @param m 字节开始序号
     * @param n 字节结束序号
     * @return 16进制
     */
    private static String bufferToHex(byte[] bytes, int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    /**
      * @Title: appendHexPair
      * @Description: 单字节转成双字节
      * @param bt 字节
      * @param stringbuffer 缓冲字符串
      */
    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        char c0 = HEX_DIGITS[(bt & 0xf0) >> 4];
        char c1 = HEX_DIGITS[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }
}
