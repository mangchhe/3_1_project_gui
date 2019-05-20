package cse.teamproject.client;

import cse.teamproject.client.gui.MessageManagement;

import java.net.Socket;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

/**
 * @author 하주현
 * 
 * 서버에 연결시도
 * @since 2019-05-20
 */

public class ClientBackground {
    
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    Scanner sc = new Scanner(System.in);
    Receiver receiver = new Receiver();
    MessageManagement messageManagement;
    
    public void connect(){
        
        try{
            
            socket = new Socket("localhost",7777);
            System.out.println("접속에 성공하였습니다.");
            
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            
            System.out.println("닉네임 입력해주세요");
            
            receiver.start();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    class Receiver extends Thread{
    	public void run() {
    		while(true) {
    			try {
                               String msg = in.readUTF();
                               messageManagement.appendMsg(msg);
    			}catch(IOException e) {
    				System.out.println("서버와의 연결이 끊겼습니다.");
    				break;
    			}
    		}
    	}
    }
    
    // 연동
    public final void setGui(MessageManagement gui){
        messageManagement=gui;
    }
    
    public void sendMsg(String msg){
        try{
            out.writeUTF(msg);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}