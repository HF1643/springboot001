package com.cc.springboot.util;



import com.alibaba.fastjson.JSONObject;




public class JsonResponse {

    public static JSONObject success(){
        JSONObject object = new JSONObject();
        JSONObject object1 = new JSONObject();
        object.put("response",object1);

        object.put("code","1");
        object.put("msg","请求成功");
        return object;
    }

    public static JSONObject failure(){
        JSONObject object = new JSONObject();
        JSONObject object1 = new JSONObject();
        object.put("response",object1);

        object.put("code","0");
        object.put("msg","请求失败");
        return object;
    }
    public static JSONObject failureMobile(){
        JSONObject object = new JSONObject();
        JSONObject object1 = new JSONObject();
        object.put("response",object1);

        object.put("code","0");
        object.put("msg","请求失败,电话号码重复");
        return object;
    }

    /**
     * 对象放进响应body
     * */
    public static  void putIntoBody(JSONObject object,Object obj){
        JSONObject response = object.getJSONObject("response");
        if (null == response){
            throw new NullPointerException("can't find response---");
        }

        response.put("body",obj);
    }
  
    
    
    

    public static void setToSuccess(JSONObject obj){
        obj.put("code", "1");
        obj.put("msg", "请求成功");
    }

    public static void setToFailure(JSONObject obj){
        obj.put("code", "0");
        obj.put("msg", "请求失败");
    }

    public static void putMsg(JSONObject object,String msg){
        object.put("msg",msg);
    }

    public static void putCode(JSONObject object,String code){
        object.put("code",code);
    }

}
