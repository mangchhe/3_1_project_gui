package Management;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MessageManagementGui extends JFrame {
    
        JTextArea jta = new JTextArea(40, 20);
        JTextField jtf = new JTextField(20);
        
    public MessageManagementGui(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(300,400);
        setTitle("관리자 채팅");
        setLayout(null);
        Dimension frameSize = this.getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);

        jta.setBounds(20,20,247,280);
        add(jta);
        
        jtf.setBounds(20,320,247,20);
        add(jtf);
        
    }
    
    public static void main(String[] args){
        
        new MessageManagementGui();
        
    }
    
}
