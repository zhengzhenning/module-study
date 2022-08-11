package com.yibu.modulestudy.lambda.demo5;

/**
 * @program: module-study
 * @description: 信
 * @packagename: com.yibu.modulestudy.lambda.demo5
 * @author: 振振
 * @date: 2022-07-22 18:10
 **/
public class Letter{
    public static String addHeader(String text){
        return "From Raoul, Mario and Alan: " + text;
    }
    public static String addFooter(String text){
        return text + " Kind regards";
    }
    public static String checkSpelling(String text){
        return text.replaceAll("labda", "lambda");
    }
}
