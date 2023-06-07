package com.potato.controller;

import com.alibaba.fastjson.JSON;

/**
 * @Author potato
 * @PackageName:com.potato.controller
 * @Description: TODO
 * @Date 2022-12-11 20:05
 */

public class text {
    public static void main(String[] args) {
        String string = JSON.toJSONString(true);
        System.out.println(string);
    }
}
