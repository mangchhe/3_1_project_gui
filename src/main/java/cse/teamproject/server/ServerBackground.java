package cse.teamproject.server;

import cse.teamproject.server.gui.MessageManagement;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @author 하주현
 * 
 * 서버 소켓 생성하여 클라이언트 접속을 기다린다.
 * @since 2019-05-07
 */

public class ServerBackground extends Thread {
    
    private ServerSocket serverSocket;
    private Socket socket;
    private Scanner sc = new Scanner(System.in);
    private User user = new User();
    // 연동
    MessageManagement messageManagement;
    
   public ServerBackground(){
        try {
            serverSocket = new ServerSocket(7777);
        } catch (IOException e) {
            e.printStackTrace();
        }
   }
    public void run(){
         while(true){
             try {
                 socket=serverSocket.accept();
             } catch (IOException e) {
                 e.printStackTrace();
             }
             Access a=new Access(socket);
             a.start();
         }
    }
    
    class Access extends Thread{

    private DataInputStream in;
    private DataOutputStream out;
    private String nickName;
    private FileInputStream fin;
    
        public Access(Socket socket){
            try{
                // 통로 연결
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());           
                // 파일 전송
                for(int i=0;i<20;i++){
                    fin = new FileInputStream("reservationState/"+i+".txt");
                    while(true){
                        int data = fin.read();
                        if(data == -1){
                            out.write(0);
                            break;
                        }
                        out.write(data);
                    }
                }
                fin.close();
                
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
        public void run(){
            try {                
                nickName=in.readUTF();
                user.AddClient(nickName, socket);
                messageManagement.appendMsgFist(nickName);
                while(true){        
                    String msg = in.readUTF();
                    messageManagement.appendMsg(nickName,msg);
                }
            } catch (IOException e) {
                messageManagement.appendMsgEnd(nickName);
                user.RemoveClient(nickName);
            }
        }
    }
    // 연동
    public final void setGui(MessageManagement gui){
        messageManagement=gui;
    }
    
}
