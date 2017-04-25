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

public class Test2 {

	public static void main(String[] args) {
		//String host = "https://baoming.cxcyds.com/index.php?s=/ajax/getRegion&pid=18";
		String host = "https://baoming.cxcyds.com/index.php?s=/ajax/getthreelevel&pid=630&type=province&sid=2";
		String path = "";
		String method = "GET";
		Map<String, String> headers = new HashMap<String, String>();
		// 最后在header中的格式(中间是英文空格)为Authorization:APPCODE
		// 83359fd73fe94948385f570e3c139105
		Map<String, String> querys = new HashMap<String, String>();

		try {
			/**
			 * 重要提示如下: HttpUtils请从
			 * https://github.com/aliyun/api-gateway-demo-sign
			 * -java/blob/master/src
			 * /main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java 下载
			 * 
			 * 相应的依赖请参照
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob
			 * /master/pom.xml
			 */
			HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
			// 获取response的body
			String responseString = EntityUtils.toString(response.getEntity());
//			System.out.println(responseString);
			
	
			Map<String, Object> map = JSON.parseObject(responseString);
	        String string = map.get("eht").toString();
	        
	        String stringOfEht = map.get("eht").toString();
	        String stringOfFhq = (String) map.get("fhq").toString();
	        String stringOfKjy = (String) map.get("kjy").toString();
	        
	        List<Eht> listOfEht = JSON.parseArray(stringOfEht,Eht.class);
	        List<Fhq> listOfFhq = JSON.parseArray(stringOfFhq,Fhq.class);
	        List<Kjy> listOfKjy = JSON.parseArray(stringOfKjy,Kjy.class);
			
//	        System.out.println(listOfEht.get(0).getRemark());
//	        System.out.println(listOfFhq.get(0).getRemark());
//	        System.out.println(listOfKjy.get(0).getRemark());
	        
	        String eht = "";
	        int pid = 14;
	        
	       for (int i = 0; i < listOfEht.size(); i++) {
	       
	    	   Eht e =  listOfEht.get(i);
				
				if (i == 0) {
					eht += "[{";
				}
				
				if (i > 0) {
					eht += "\r{";
				}
					
				eht += "\r\tid:"+e.getId()+",\r\tpid:"+pid+",\r\tremark:"+e.getRemark()+"";
				
				if (i < listOfEht.size()-1) {
					eht += "\n},";
				}
				
				if (i == listOfEht.size() -1) {
					eht += "\n}]";
				}
				
	       }
	       
	       System.out.println("eht = " + eht);
	       
	        //System.out.println(convertUnicode(responseString));
			
			//Map<String, Object> map = JSON.parseObject(responseString);

			//Map map2 = (Map) map.get("showapi_res_body");
			//System.out.println(map2.get("city"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String convertUnicode(String ori){
        char aChar;
        int len = ori.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len;) {
            aChar = ori.charAt(x++);
            if (aChar == '\\') {
                aChar = ori.charAt(x++);
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = ori.charAt(x++);
                        switch (aChar) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            value = (value << 4) + aChar - '0';
                            break;
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                            value = (value << 4) + 10 + aChar - 'a';
                            break;
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                            value = (value << 4) + 10 + aChar - 'A';
                            break;
                        default:
                            throw new IllegalArgumentException(
                                    "Malformed   \\uxxxx   encoding.");
                        }
                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);
 
        }
        return outBuffer.toString();
        
	}
}
