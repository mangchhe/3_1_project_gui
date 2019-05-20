package cse.teamproject.server;

import cse.teamproject.server.gui.MessageManagement;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

/**
 * @author 하주현
 * 
 * 서버 소켓 생성하여 클라이언트 접속을 기다린다.
 * @since 2019-05-20
 */

public class ServerBackground {
    
    private ServerSocket serverSocket;
    private Socket socket;
    private Scanner sc = new Scanner(System.in);
    private User user = new User();
    // 연동
    MessageManagement messageManagement;
    
    public void setting(){
        try{
            serverSocket = new ServerSocket(7777);
            user.start();
            while(true){
                System.out.println("접속 대기중");
                socket=serverSocket.accept();
                System.out.println(socket.getInetAddress()+"님께서 접속하셨습니다.");
                Access a=new Access(socket);
                a.start();
            }        
        
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    class Access extends Thread{

    private DataInputStream in;
    private DataOutputStream out;
    private String nickName;
    
        public Access(Socket socket){
            try{
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());           
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
        public void run(){
            try {                
                nickName=in.readUTF();
                user.AddClient(nickName, socket);
                while(true){        
                    String msg = in.readUTF();
                    System.out.println(nickName + " : " + msg);
                    // 연동
                    messageManagement.appendMsg(msg);
                }
            } catch (IOException e) {
                System.out.println(nickName+"님께서 퇴장하셨습니다.");
                user.RemoveClient(nickName);
            }
        }
    }
    // 연동
    public final void setGui(MessageManagement gui){
        messageManagement=gui;
    }
    
}
