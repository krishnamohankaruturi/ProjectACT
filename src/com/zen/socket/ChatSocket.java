package com.zen.socket;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatSocket extends Thread {
	Socket socket;
	
	public ChatSocket(Socket s){
		this.socket = s;
	}

	public void out(String out){
		try {
			socket.getOutputStream().write(out.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run(){
	
		int count = 0;
		while (true){
			count ++;
			out("loop+" + count);
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
