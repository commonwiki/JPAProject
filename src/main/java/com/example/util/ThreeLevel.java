package com.example.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.example.address.entity.Eht;
import com.example.address.entity.Fhq;
import com.example.address.entity.Kjy;

public class ThreeLevel {

	private String eht;
	private String fhq;
	private String kjy;
	
	
	public  void get (int pid,int sid) {
		
		eht = "";
		fhq = "";
		kjy = "";
		
		String host = "https://baoming.cxcyds.com/index.php?s=/ajax/getthreelevel&pid="+pid+"&type=city&sid=" + sid;
		String path = "";
		String method = "GET";
		Map<String, String> headers = new HashMap<String, String>();
		Map<String, String> querys = new HashMap<String, String>();
		try {

			HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
			// 获取response的body
			String responseString = EntityUtils.toString(response.getEntity());
			Map<String, Object> map = JSON.parseObject(responseString);
			
			
	        String stringOfEht =  map.get("eht").toString();
	        String stringOfFhq =  map.get("fhq").toString();
	        String stringOfKjy =  map.get("kjy").toString();
	        
	        List<Eht> listOfEht = JSON.parseArray(stringOfEht,Eht.class);
	        List<Fhq> listOfFhq = JSON.parseArray(stringOfFhq,Fhq.class);
	        List<Kjy> listOfKjy = JSON.parseArray(stringOfKjy,Kjy.class);
			
	        
	       for (int i = 0; i < listOfEht.size(); i++) {
	       
	    	   Eht e =  listOfEht.get(i);
				
				if (i == 0) {
					eht += "[{";
				}
				
				if (i > 0) {
					eht += "\r\t\t{";
				}
					
				eht += "\r\t\t\tid:"+e.getId()+",\r\t\t\tremark:"+e.getRemark()+"";
				
				if (i < listOfEht.size()-1) {
					eht += "\n\t\t},";
				}
				
				if (i == listOfEht.size() -1) {
					eht += "\n\t\t}]";
				}
				
	       }
	       
	  
	       for (int i = 0; i < listOfFhq.size(); i++) {
		       
	    	   Fhq f =  listOfFhq.get(i);
				
				if (i == 0) {
					fhq += "[{";
				}
				
				if (i > 0) {
					fhq += "\r\t\t{";
				}
					
				fhq += "\r\t\t\tid:"+f.getId()+",\r\t\t\tremark:"+f.getRemark()+"";
				
				if (i < listOfFhq.size()-1) {
					fhq += "\n\t\t},";
				}
				
				if (i == listOfFhq.size() -1) {
					fhq += "\n\t\t}]";
				}
				
	       }
	       
	       for (int i = 0; i < listOfKjy.size(); i++) {
		       
	    	   Kjy k =  listOfKjy.get(i);
				
				if (i == 0) {
					kjy += "[{";
				}
				
				if (i > 0) {
					kjy += "\r\t\t{";
				}
					
				kjy += "\r\t\t\tid:"+k.getId()+",\r\t\t\tremark:"+k.getRemark()+"";
				
				if (i < listOfKjy.size()-1) {
					kjy += "\n\t\t},";
				}
				
				if (i == listOfKjy.size() -1) {
					kjy += "\n\t\t}]";
				}
				
	       }
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public String getEht() {
		return eht;
	}


	public String getFhq() {
		return fhq;
	}


	public String getKjy() {
		return kjy;
	}
	
	
}
