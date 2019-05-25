package cse.teamproject.server.gui;

import cse.teamproject.designpattern.factory.GuestRoom;
import cse.teamproject.designpattern.singleton.GuestRoomStorage;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author 하주현
 * 
 * 괸라자가 비품 관리하는 창
 * @since 2019-05-19
 *         2019-05-26 JTable 수정 시 new를 하여 테이블을 다시 생성해주어야 하기 때문에 model 사용
 *                    데이터 추가 / 기능 구현
 */

public class InventoryManagement extends JFrame {
    
    private JButton btn,btn2;
    private JLabel label;
    GuestRoomStorage guestRoomStorage = GuestRoomStorage.getInstance();
    GuestRoom[] guestRoom = guestRoomStorage.getStorage();
    
    public InventoryManagement(){
        
        String header[] = {"객실 번호","수건","배게","이불","침대"};
        String contents[][]={};
        
        setTitle("비품 재고");
        setSize(600,400);
        setLayout(null);
        
        Dimension frameSize = this.getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
      
        DefaultTableModel model = new DefaultTableModel(contents,header);
        JTable table = new JTable(model);
        JScrollPane sc = new JScrollPane(table);
        sc.setBounds(160,90,400,240);
        add(sc);
        DefaultTableModel m = (DefaultTableModel)table.getModel();
          
        label = new JLabel("재고 관리");
        label.setBounds(300,0,200,80);
        label.setFont(new Font("",Font.BOLD,20));
        add(label);
        
        btn = new JButton("검색");
        btn.setBounds(30,100,100,60);
        add(btn);
        
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new InventorySearch();
            }
        });
        
        btn2 = new JButton("변경");
        btn2.setBounds(30,180,100,60);
        add(btn2);
        
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new InventoryPermute();
            }
        });
        
        ClockMessage clockMessage = new ClockMessage();
        clockMessage.setBounds(30,0,100,100);
        new Thread(clockMessage).start();
        add(clockMessage);
        
        for(int i=0;i<20;i++){
            m.insertRow(i, new Object[]{String.valueOf(i+1), String.valueOf(guestRoom[i].getTowel()), String.valueOf(guestRoom[i].getPillow()), 
                String.valueOf(guestRoom[i].getBlanket()), String.valueOf(guestRoom[i].getBed())});
        }
       
        setVisible(true);
        
    }
    
}
