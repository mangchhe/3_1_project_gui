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
 * @since 2019-05-07
 */

public class ClientBackground {
    
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner sc = new Scanner(System.in);
    private Receiver receiver = new Receiver();
    private MessageManagement messageManagement;
    
    public void connect(){
        
        try{
            
            socket = new Socket("58.126.125.202",7777);
            messageManagement.msgMe("서버와 연결이 되었습니다.");
            
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            
            messageManagement.msgMe("사용하실 닉네임을 입력해주세요");
            
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
    				messageManagement.msgMe("서버와의 연결이 끊겼습니다.");
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