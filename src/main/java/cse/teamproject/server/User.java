package cse.teamproject.server;

import cse.teamproject.server.gui.MessageManagement;

import java.util.HashMap;
import java.io.DataOutputStream;
import java.util.Collections;
import java.net.Socket;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author 하주현
 * 
 * 클라이언트의 정보와 클라이언트에게 메시지를 전달한다(에코메시지)
 * @since 2019-05-20
 */

public class User extends Thread {
    
    String echoMsg;
    String nickName;
    Scanner sc = new Scanner(System.in);
    static HashMap<String, DataOutputStream> user = new HashMap<String, DataOutputStream>();
    
    
    public User(){
        Collections.synchronizedMap(user);
    }
    
    public void AddClient(String nickName,Socket socket){
        try{
            user.put(nickName,new DataOutputStream(socket.getOutputStream()));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void RemoveClient(String nickName){
        user.remove(nickName);
    }
    
    public void sendMsg(String msg){
            echoMsg=msg;
            System.out.println(user.keySet());
            System.out.println(user.keySet().iterator());
            Iterator it=user.keySet().iterator();
            if(echoMsg.equals("user")){
                while(it.hasNext()){
                    nickName=(String)it.next();
                    System.out.println("userName" + " : " + nickName);
                }
                System.out.println("총 "+user.size()+"명");                
            }
            else{
                while(it.hasNext()){
                    nickName=(String)it.next();
                    try {
                        user.get(nickName).writeUTF("서버 : " + echoMsg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }            
                }
            }
    }
}
