package com.demo;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * @Classname JsonTes
 * @Description TODO
 * @Date 2019/10/13 10:31
 * @Created by zjl
 */
public class JsonTes {
    public static void main(String[] args) {
        HashMap <String, Object> map = new HashMap <String, Object>( );
        map.put("name","34");
        map.put("age",12);
        JSONArray objects = new JSONArray(map);
    }

}
