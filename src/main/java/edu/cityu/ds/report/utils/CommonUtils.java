package edu.cityu.ds.report.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonUtils {

    public static DateFormat timestampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Map<String, Object> listMap2Map(List<Map<String, Object>> list, String key, String value) {
        if(list == null) {
            return null;
        }

        Map<String, Object> resultMap = new HashMap<>();
        for(Map<String, Object> map: list) {
            resultMap.put(String.valueOf(map.get(key)), map.get(value));
        }

        return resultMap;
    }

    public static Map<String, Map<String, Object>> listMap2MapMap(List<Map<String, Object>> list, String key1, String key2, String value) {
        if(list == null) {
            return null;
        }

        Map<String, Map<String, Object>> resultMap = new HashMap<>();
        for(Map<String, Object> map: list) {
            String key1Value = String.valueOf(map.get(key1));
            if(resultMap.get(key1Value) == null) {
                resultMap.put(key1Value, new HashMap<>());
            }
            resultMap.get(key1Value).put(String.valueOf(map.get(key2)), map.get(value));
        }

        return resultMap;
    }

}
