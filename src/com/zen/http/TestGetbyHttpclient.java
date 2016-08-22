package com.zen.http;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class TestGetbyHttpclient {

	public static void main(String[] args) {

		new Get().start();
	}
	
	static class Get extends Thread{
		HttpClient client = HttpClients.createDefault();
		
		
		@Override
		public void run(){
			HttpGet get = new HttpGet("Http://www.baidu.com");
			try {
				
				HttpResponse response = client.execute(get);
				HttpEntity entity = response.getEntity();
				String result = EntityUtils.toString(entity,"UTF-8");
				
				System.out.println(result);
				
				
				
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto- catch block
				e.printStackTrace();
			}
		}
		
	}

}
