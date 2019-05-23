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
 * @since 2019-05-07
 */

public class User extends Thread {
    
    private String echoMsg;
    private String nickName;
    private Scanner sc = new Scanner(System.in);
    private static HashMap<String, DataOutputStream> user = new HashMap<String, DataOutputStream>();
    
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
        Iterator it=user.keySet().iterator();
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

