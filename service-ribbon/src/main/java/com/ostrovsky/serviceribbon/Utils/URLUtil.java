package com.ostrovsky.serviceribbon.Utils;

import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;

/**
 * 提供Url的工具类
 * Func：
 *      Class.field
 *      Class.getXXX();
 */
@Component
public class URLUtil {
    //通用Url
    public static final String CLIENT_URL = "HTTP://service-client";

    /**
     * 获取Ostrovsky客户端接口的访问地址（接口无参）
     * @param apiUrl 接口url
     * @return 返回URL地址
     */
    public static String getClientURL(String apiUrl){
        String url = CLIENT_URL+apiUrl;
        return url;
    }

    /**
     * 获取客户端接口的访问地址（接口含参）
     * @param apiUrl 调用接口的URL
     * @param map 传入接口的参数（无参则传入空map）
     * @return url 客户端接口的URL
     */
    public static String getClientURL(String apiUrl, Map map){
        StringBuffer url = new StringBuffer(CLIENT_URL+apiUrl);
        //判断接口是否含参
        if(map.isEmpty()){
            return url.toString();
        }else{
            //拼接参数
            url.append("?");
            //遍历map参数集合..
            Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();
            while (entries.hasNext()){
                Map.Entry<String, Object> entry = entries.next();
                String key = entry.getKey();
                Object value = entry.getValue();
                //拼接参数
                url.append(key+"="+value+"&&");
            }
            return  url.substring(url.length()-1).toString();
        }
    }
}
