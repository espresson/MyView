package com.example.myview.utils;

/**
 * 判断字符是否是汉字
 */
public class IsChineseUtils {

    public static boolean isChineseChar(char c){
        return String .valueOf(c).matches("[\u4e00-\u9fa5]");
    }
}
