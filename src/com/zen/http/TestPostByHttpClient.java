package com.zen.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class TestPostByHttpClient {

	public static void main(String[] args) {
		
		//http://fanyi.youdao.com/openapi.do
		//keyfrom=jkxx-test&key=1792372446&type=data&doctype=xml&version=1.1&q=welcome

		new TestPost().start();
	}
	
	static class TestPost extends Thread{
			HttpClient client = HttpClients.createDefault();
			
			
			@Override
			public void run(){
				HttpPost Post = new HttpPost("http://fanyi.youdao.com/openapi.do");
				try {
					List<BasicNameValuePair> parameters = new ArrayList<>();
					parameters.add(new BasicNameValuePair("keyfrom", "jkxx-test"));
					parameters.add(new BasicNameValuePair("key", "1792372446"));
					parameters.add(new BasicNameValuePair("type", "data"));
					parameters.add(new BasicNameValuePair("doctype", "xml"));
					parameters.add(new BasicNameValuePair("version", "1.1"));
					parameters.add(new BasicNameValuePair("q", "welcome"));
					
					Post.setEntity(new UrlEncodedFormEntity(parameters,"UTF-8"));
					HttpResponse response = client.execute(Post);
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