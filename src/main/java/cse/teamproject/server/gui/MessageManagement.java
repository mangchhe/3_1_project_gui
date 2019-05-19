package cse.teamproject.server.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author 하주현
 * 
 * 관리자가 사용자와 소통하는 메시지 창
 * @since 2019-05-19
 */

public class MessageManagement extends JFrame {
    
        JTextArea jta = new JTextArea(40, 20);
        JTextField jtf = new JTextField(20);
        
    public MessageManagement(){

        setVisible(true);
        setSize(300,400);
        setTitle("관리자 채팅");
        setLayout(null);
        Dimension frameSize = this.getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) , (windowSize.height - frameSize.height));

        jta.setBounds(20,20,247,280);
        add(jta);
        jta.setEnabled(false);
        
        jtf.setBounds(60,320,207,20);
        jtf.setText("할말을 입력해주세요.");
        add(jtf);
        
        JLabel label = new JLabel("할말 : ");
        label.setBounds(20,280,100,100);
        add(label);
        
    }
    
}
