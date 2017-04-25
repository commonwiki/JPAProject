package com.example.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.example.address.entity.Address;

public class ZhongChuangData {

public  static List<Address> get (int sid) {
		
		
		String host = "https://baoming.cxcyds.com/index.php?s=/ajax/getzhongchuang/pid/" + sid;
		String path = "";
		String method = "GET";
		Map<String, String> headers = new HashMap<String, String>();
		Map<String, String> querys = new HashMap<String, String>();
		
		List<Address> list = null;
		
		try {

			HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
			// 获取response的body
			String responseString = EntityUtils.toString(response.getEntity());
			
			//Map<String, Object> map = JSON.parseObject(responseString);
			
			System.out.println(StringConvert.convertUnicode(responseString));
			
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return  list;
	}
	
}
