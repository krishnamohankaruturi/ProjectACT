package com.zen.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerListenner extends Thread {

	@Override
	public void run(){
		try {

			ServerSocket serverSocket = new ServerSocket(12345);
			while(true){
				//block
				Socket socket = serverSocket.accept();
				//��������
				JOptionPane.showMessageDialog(null,"�пͻ������ӵ��˱�����12345�˿�");
				//��socket���ݸ��µ��߳�
				new ChatSocket(socket).start();
			}
			
			
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
