package com.example.demo.utils;

import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

public class AniUtils {
    public static final String APP_ID = "50125616";

    public static final String API_KEY = "2GQXrtC9hRTfAToPG8N0DCwG";
    public static final String SECRET_KEY = "DqNhu9OyH3oOMqi43EwUYtGoWyla0f9x";

    public static String identifyAniPic(MultipartFile file) throws IOException {
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
        // 调用接口
        JSONObject res = client.animalDetect(file.getBytes(), new HashMap<String, String>());

        JSONObject result = res.getJSONArray("result").getJSONObject(0);
        String str = "经过动物图片识别，有" + result.getDouble("score") * 100 + "%的概率是" + result.get("name").toString();
        return str;
    }
}
