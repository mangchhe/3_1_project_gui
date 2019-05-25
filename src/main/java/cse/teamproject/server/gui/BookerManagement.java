package cse.teamproject.server.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author 하주현
 * 
 * 예약자를 관리하는 프레임
 * @since 2019-05-19
 */

public class BookerManagement extends JFrame {
    
    private JButton btn,btn2,btn3,btn4;
    private JLabel label;
    
    public BookerManagement(){
        
        String header[] = {"예약자 이름","객실 번호","시작 날짜","끝 날짜"};
        String contents[][]={};

        setTitle("예악자 관리");
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
        
        setVisible(true);
       
    }
    
}
