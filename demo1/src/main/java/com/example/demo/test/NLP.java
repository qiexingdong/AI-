package com.example.demo.test;

import com.baidu.aip.nlp.AipNlp;
import org.json.JSONObject;

import java.util.HashMap;

public class NLP {
    //设置APPID/AK/SK
    public static final String APP_ID = "50246792";
    public static final String API_KEY = "EQAfqNtmu9GGgn65n8g0qGix";
    public static final String SECRET_KEY = "Q7rPFu3RFCkoRYynQs1xTTgRivsL5GmV";

    public static void main(String[] args) {
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

        // 调用接口
        /**
        * 1.词法分析
        */
        System.out.println("-----------词法分析-----------");
        String text_1 = "百度是一家高科技公司";
        JSONObject res_1 = client.lexer(text_1, null);
        System.out.println(res_1.toString(2));
        /**
         * 2.依存句法分析
         */
        String text_2 = "今天天气不错";

        // 传入可选参数调用接口
        System.out.println("---------依存句法分析---------");
        HashMap<String, Object> options_2 = new HashMap<String, Object>();
        options_2.put("mode", 1);

        // 依存句法分析
        JSONObject res_2 = client.depParser(text_2, options_2);
        System.out.println(res_2.toString(2));
        /**
         * 3.词向量表示
         */

        /**
         * 4.DNN语言模型
         */

        /**
         * 5.词义相似度
         */

        /**
         * 6.短文本相似度
         */

        /**
         * 7.评论观点抽取
         */

        /**
         * 8.情感倾向分析
         */

        /**
         * 9.文章标签
         * 文章标签服务能够针对网络各类媒体文章进行快速的内容理解，根据输入含有标题的文章，
         * 输出多个内容标签以及对应的置信度，用于个性化推荐、相似文章聚合、文本内容分析等场景。
         */

        /**
         * 10.文章分类
         */

        /**
         * 11.文本纠错
         */
        System.out.println("---------文本纠错---------");
        String text_11 = "百度是一家人工只能公司";
        // 传入可选参数调用接口
        HashMap<String, Object> options_11 = new HashMap<String, Object>();
        // 文本纠错
        JSONObject res_11 = client.ecnet(text_11, options_11);
        String str_11 = res_11.getJSONObject("item").getString("correct_query");
        System.out.println(str_11);
        /**
         * 12.对话情绪识别接口
         */

        /**
         * 13.新闻摘要接口
         */

        /**
         * 14.地址识别接口
         */

    }
}
