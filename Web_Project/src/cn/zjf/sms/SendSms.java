package cn.zjf.sms;

import java.util.HashMap;
import java.util.Random;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
/*
pom.xml
<dependency>
  <groupId>com.aliyun</groupId>
  <artifactId>aliyun-java-sdk-core</artifactId>
  <version>4.0.3</version>
</dependency>
*/
public class SendSms {
	public static int random() {
		Random r = new Random();
		int num = r.nextInt(900000)+100000;
		return num;
	}
	
	public static boolean send(String phoneNum,int code) {
		return send(phoneNum,code+"");
	}
    
    public static boolean send(String phoneNum,String code) {
    	 DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FhrVcGmr3WK1WfoLjFT", "plOAY3gZmP71de7eqbtUT33O3ajTFx");
         IAcsClient client = new DefaultAcsClient(profile);

         CommonRequest request = new CommonRequest();
         request.setMethod(MethodType.POST);
         request.setDomain("dysmsapi.aliyuncs.com");
         request.setVersion("2017-05-25");
         request.setAction("SendSms");
         request.putQueryParameter("RegionId", "cn-hangzhou");
         request.putQueryParameter("PhoneNumbers", ""+phoneNum+"");
         request.putQueryParameter("SignName", "¿ì¼þEÕ»");
         request.putQueryParameter("TemplateCode", "SMS_175125546");
         request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
         try {
             CommonResponse response = client.getCommonResponse(request);
             System.out.println(response.getData());
             String json = response.getData();
             Gson g = new Gson();
             HashMap map = g.fromJson(json, HashMap.class);
             if("OK".equals(map.get("Message"))) {
            	 return true;
             }
         } catch (ServerException e) {
             e.printStackTrace();
         } catch (ClientException e) {
             e.printStackTrace();
         }
         return false;
    }
}