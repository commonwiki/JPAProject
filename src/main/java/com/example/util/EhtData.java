package com.example.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.example.address.entity.Address;

public class EhtData {
	
	
	public  static List<Address> get (int pid,int sid) {
		
		
		String host = "https://baoming.cxcyds.com/index.php?s=/ajax/getthreelevel&pid="+pid+"&type=city&sid=" + sid;
		String path = "";
		String method = "GET";
		Map<String, String> headers = new HashMap<String, String>();
		Map<String, String> querys = new HashMap<String, String>();
		
		List<Address> list = null;
		
		try {

			HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
			// 获取response的body
			String responseString = EntityUtils.toString(response.getEntity());
			Map<String, Object> map = JSON.parseObject(responseString);
			
			
	        String stringOfEht =  map.get("eht").toString();
	        //String stringOfFhq =  map.get("fhq").toString();
	        //String stringOfKjy =  map.get("kjy").toString();
	        
	        list = JSON.parseArray(stringOfEht,Address.class);
	        
	        //List<Fhq> listOfFhq = JSON.parseArray(stringOfFhq,Fhq.class);
	        //List<Kjy> listOfKjy = JSON.parseArray(stringOfKjy,Kjy.class);
			
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return  list;
	}
	
}
