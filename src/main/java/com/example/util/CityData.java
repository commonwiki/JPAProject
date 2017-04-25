package com.example.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.example.address.entity.Address;

public class CityData {
	
	public static List<Address> getByPId (int id) {
		
		String host = "https://baoming.cxcyds.com/index.php?s=/ajax/getRegion&pid=" + id;
		String path = "";
		String method = "GET";
		Map<String, String> headers = new HashMap<String, String>();
		Map<String, String> querys = new HashMap<String, String>();

		String responseString = null;
		List<Address> list = null;
		try {
			HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
			responseString = EntityUtils.toString(response.getEntity());
			responseString = StringConvert.convertUnicode(responseString);
			list = JSON.parseArray(responseString,Address.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return  list;
	}
	
}
