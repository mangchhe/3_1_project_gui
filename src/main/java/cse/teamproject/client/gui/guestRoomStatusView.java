package cse.teamproject.client.gui;

import javax.swing.JFrame;

/**
 * @author 하주현
 * 
 * 현재 예약 할 수 있는 객실의 상태를 알려준다.
 * @since 2019-05-20
 */

public class guestRoomStatusView extends  JFrame {
    
   public guestRoomStatusView(){
       
       setVisible(true);
       setSize(600,400);
       setTitle("예약창");
       
       // 고객 채팅
       MessageManagement messageManagement = new MessageManagement();
       
   }
    
}
