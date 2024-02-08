package com.example.demo.controller;

import com.example.demo.utils.AIUtils;
import com.example.demo.utils.AniUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class AIController {
    //通用文字检测
    @RequestMapping(value = "/pic",method = RequestMethod.POST)
    public String PicToWords(@RequestParam("file") MultipartFile file) throws IOException {
        String result = AIUtils.picToWords(file);
        System.out.println(result);//检查后端是否接收到处理过后的数据，很重要
        return result;
    }
    //动物图片检测
    @RequestMapping(value = "/ani",method = RequestMethod.POST)
    public String IdentifyAniPic(@RequestParam("file") MultipartFile file) throws IOException {
    String result = AniUtils.identifyAniPic(file);
        System.out.println(result);
        return result;
    }
}
