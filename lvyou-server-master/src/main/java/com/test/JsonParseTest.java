package com.test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JsonParseTest
{
  public static JsonObject parseJson(String json)
  {
    JsonParser parser = new JsonParser();
    JsonObject jsonObj = parser.parse(json).getAsJsonObject();
    return jsonObj;
  }

  public static void main(String[] args) throws Exception {
    String jsonStr = "{\"responseHeader\":{\"rsp_seq\":\"REQ_2016120517100603111226\",\"_ASSrsp_time1\":\"2016-12-05 17:10:07.082\",\"_rsp_app1\":\"portal-001\",\"retinfo\":{\"retcode\":\"0\",\"retcause\":\"\",\"retmsg\":\"\"}},\"msgbody\":{\"pageObj\":\"\",\"dynamicList\":[{\"imageList\":[],\"comInfoList\":\"\",\"ctime\":\"\",\"sid\":2,\"commentnote\":\"今天去旅游了!\",\"cTime\":\"\",\"commentaddress\":\"wwwww\",\"username\":\"陈海\"},{\"imageList\":[],\"comInfoList\":\"\",\"ctime\":\"\",\"sid\":1,\"commentnote\":\"这是一条动态!\",\"cTime\":\"\",\"commentaddress\":\"wwwww\",\"username\":\"陈海\"}]}}";
    try {
      toMap(parseJson(jsonStr));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Map<String, Object> toMap(JsonObject json)
  {
    Map map = new HashMap();
    Set entrySet = json.entrySet();
    for (Iterator iter = entrySet.iterator(); iter.hasNext(); ) {
      Map.Entry entry = (Map.Entry)iter.next();
      String key = (String)entry.getKey();
      Object value = entry.getValue();
      if ((value instanceof JsonArray))
        map.put(key, toList((JsonArray)value));
      else if ((value instanceof JsonObject))
        map.put(key, toMap((JsonObject)value));
      else
        map.put(key, value);
    }
    return map;
  }

  public static List<Object> toList(JsonArray json)
  {
    List list = new ArrayList();
    for (int i = 0; i < json.size(); i++) {
      Object value = json.get(i);
      if ((value instanceof JsonArray)) {
        list.add(toList((JsonArray)value));
      }
      else if ((value instanceof JsonObject)) {
        list.add(toMap((JsonObject)value));
      }
      else {
        list.add(value);
      }
    }
    return list;
  }
}