package cse.teamproject.server.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author 하주현
 * 
 * 예약자를 관리하는 프레임
 * @since 2019-05-19
 */

public class BookerManagement extends JFrame {
    
    JButton btn,btn2,btn3,btn4;
    JLabel label;
    
    public BookerManagement(){

        setTitle("예악자 관리");
        setVisible(true);
        setSize(600,400);
        setLayout(null);
        
        Dimension frameSize = this.getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
        
        label = new JLabel("예약자 관리");
        label.setBounds(300,0,200,80);
        label.setFont(new Font("",Font.BOLD,20));
        add(label);
        
        btn = new JButton("검색");
        btn.setBounds(30,100,100,40);
        add(btn);
        btn2 = new JButton("추가");
        btn2.setBounds(30,160,100,40);
        add(btn2);
        btn3 = new JButton("삭제");
        btn3.setBounds(30,220,100,40);
        add(btn3);
        btn4 = new JButton("변경");
        btn4.setBounds(30,280,100,40);
        add(btn4);
        
        ClockMessage clockMessage = new ClockMessage();
        clockMessage.setBounds(30,0,100,100);
        new Thread(clockMessage).start();
        add(clockMessage);
       
        String header[] = {"예약자 이름","객실 번호","시작 날짜","끝 날짜"};
        String contents[][]={{"1","2","3","4"},{"1","2","3","4"}};
        JTable table = new JTable(contents,header);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(160,90,400,240);
        add(scrollPane);
        
        //table.setEnabled(false);
        // table.setValueAt("헤에", 1,0); 테이블에 값 추가하기
        
        /*
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                Thread.interrupted();
            }
        });
        */
    }
    
}
