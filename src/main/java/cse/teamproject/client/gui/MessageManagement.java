package cse.teamproject.client.gui;

import cse.teamproject.client.ClientBackground;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author 하주현
 * 
 * 사용자가 관리자와 소통 할 수 있는 메시지창
 * @since 2019-05-19
 */

public class MessageManagement extends JFrame {
    
        private JTextArea jta = new JTextArea(40, 20);
        private JTextField jtf = new JTextField(20);
        private JButton btn;
        private ClientBackground clientBackground = new ClientBackground(); 
        
    public MessageManagement(){

        setSize(300,400);
        setTitle("고객 채팅");
        setLayout(null);
        Dimension frameSize = this.getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) , (windowSize.height - frameSize.height));

        JLabel label = new JLabel("할말 : ");
        label.setBounds(20,280,100,100);
        add(label);
        
        jta.setBounds(20,20,247,280);
        add(jta);
        jta.setEnabled(false);
     
        jtf.setBounds(60,320,147,20);
        jtf.setText("할말을 입력해주세요.");
        add(jtf);
        
        btn = new JButton("보냄");
        btn.setBounds(217,320,50,20);
        btn.setFont(new Font("",Font.BOLD,7));
        add(btn);
        
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                clientBackground.sendMsg(jtf.getText());
                jtf.setText("");
            }
        });
        
        setVisible(true);
        //연동       
        clientBackground.setGui(this);
        clientBackground.connect();
        
    }
    
    public void appendMsg(String msg){
        jta.append(msg+"\n");
    }
    
    public void msgMe(String msg){
        jta.append(msg+"\n");
    }
}
