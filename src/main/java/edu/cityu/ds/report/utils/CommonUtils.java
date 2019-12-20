package edu.cityu.ds.report.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonUtils {

    public static DateFormat timestampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static List<String> cityReserved = Arrays.asList(new String[]{"10001", "60601", "94101"});

    public static Map<String, Object> listMap2Map(List<Map<String, Object>> list, String key, String value) {
        if(list == null) {
            return null;
        }

        Map<String, Object> resultMap = new TreeMap<>();
        if("city_id".equals(key)) {
            for(Map<String, Object> map: list) {
                String cityId = String.valueOf(map.get(key));
                if(cityReserved.contains(cityId)) {
                    resultMap.put(cityId, map.get(value));
                }
            }
        } else {
            for(Map<String, Object> map: list) {
                resultMap.put(String.valueOf(map.get(key)), map.get(value));
            }
        }

        return resultMap;
    }

    public static Map<String, Map<String, Object>> listMap2MapMap(List<Map<String, Object>> list, String key1, String key2, String value) {
        if(list == null) {
            return null;
        }

//        Map<String, Map<String, Object>> resultMap = new HashMap<>();
        Map<String, Map<String, Object>> resultMap = new TreeMap<>();
        if("city_id".equals(key1)) {
            for(Map<String, Object> map: list) {
                String cityId = String.valueOf(map.get(key1));
                if(cityReserved.contains(cityId)) {
                    if(resultMap.get(cityId) == null) {
                        resultMap.put(cityId, new TreeMap<>());
                    }
                    resultMap.get(cityId).put(String.valueOf(map.get(key2)), map.get(value));
                }
            }
        } else if("city_id".equals(key2)){
            for(Map<String, Object> map: list) {
                String key1Value = String.valueOf(map.get(key1));
                if(resultMap.get(key1Value) == null) {
                    resultMap.put(key1Value, new TreeMap<>());
                }

                String cityId = String.valueOf(map.get(key2));
                if(cityReserved.contains(cityId)) {
                    resultMap.get(key1Value).put(cityId, map.get(value));
                }
            }
        } else {
            for(Map<String, Object> map: list) {
                String key1Value = String.valueOf(map.get(key1));
                if(resultMap.get(key1Value) == null) {
                    resultMap.put(key1Value, new TreeMap<>());
                }
                resultMap.get(key1Value).put(String.valueOf(map.get(key2)), map.get(value));
            }
        }


        return resultMap;
    }
    
    public static Map<String, List> commonMaplist2Map(List<Map<String, Object>> list, String[] keys){
        
        if(list == null) { return null; }
        Map<String, List> resultMap = new TreeMap<>();
        for(String key: keys) {
            resultMap.put(key, new ArrayList());
        }
        for(Map<String, Object> map: list) {
            for(String key: keys) {
                List listKey = resultMap.get(key);
                listKey.add(map.get(key));
            }
        }
//        list.forEach(map -> resultMap.putAll(map));
        return resultMap;
    }

    public static void main(String[] args) {
    }

}
