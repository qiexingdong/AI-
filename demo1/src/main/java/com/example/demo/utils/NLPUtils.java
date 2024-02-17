package com.example.demo.utils;

import com.baidu.aip.nlp.AipNlp;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

public class NLPUtils {
    //设置APPID/AK/SK
    public static final String APP_ID = "50246792";
    public static final String API_KEY = "EQAfqNtmu9GGgn65n8g0qGix";
    public static final String SECRET_KEY = "Q7rPFu3RFCkoRYynQs1xTTgRivsL5GmV";

    public static String identifyNLP(String text) throws IOException {
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

        // 传入可选参数调用接口
        HashMap<String, Object> options = new HashMap<String, Object>();
        // 文本纠错
        JSONObject res = client.ecnet(text, options);
        String str = res.getJSONObject("item").getString("correct_query");
        return str;
    }
}
