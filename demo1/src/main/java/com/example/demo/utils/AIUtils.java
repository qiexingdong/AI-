package com.example.demo.utils;
import java.io.IOException;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;
import com.baidu.aip.ocr.AipOcr;
import org.springframework.web.multipart.MultipartFile;

public class AIUtils {
    //设置APPID/AK/SK
    public static final String APP_ID = "49784931";
    public static final String API_KEY = "6RDPv1EjdK1AMynqszp64Io0";
    public static final String SECRET_KEY = "K4pKTMjGN3mS9AzrM91Pbc6UHY4sCUcf";

    //写一个可以直接在外部调用的方法
    public static String picToWords(MultipartFile file) throws IOException {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        JSONObject res  = client.basicGeneral(file.getBytes(), new HashMap<String, String>());

        JSONArray wordsResult = res.getJSONArray("words_result");
        String result = "";
        for (int i = 0; i < wordsResult.length(); i++) {
            //    System.out.println(wordsResult.getJSONObject(i));//（2）去掉words_result格式
            JSONObject jsonObject = wordsResult.getJSONObject(i);
            Object words = jsonObject.get("words");
            String str = words.toString();
            result  += str + "";
        //    System.out.println(str);//（3）去掉words_result、words
        }
        // System.out.println(res.toString(2));//（1）保留了全部的格式
        return result;
    }
}
