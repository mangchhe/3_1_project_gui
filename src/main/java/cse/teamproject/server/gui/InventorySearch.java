package cse.teamproject.server.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author 하주현
 * 
 * 찾고자 하는 객실 비품 검색하는 창
 * @since 2019-05-26
 */

public class InventorySearch extends JFrame {
    JLabel label;
    JButton btn;
    JTextField jtf;
    public InventorySearch(){
        setTitle("재고 검색");
        setSize(300,170);
        setLocationRelativeTo(null);
        setLayout(null);
        
        label = new JLabel("객실 번호 입력 : ");
        label.setBounds(30,50,100,10);
        add(label);
        
        jtf = new JTextField();
        jtf.setBounds(130,45,100,20);
        add(jtf);
        
        btn = new JButton("확인");
        btn.setBounds(110,80,60,30);
        add(btn);
        
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Integer.parseInt(jtf.getText())<21){
                    dispose();
                    new InventorySearchResult(Integer.parseInt(jtf.getText())-1);
                }
                else{
                    JOptionPane.showMessageDialog(null, "객실번호는 20번까지 존재합니다.");
                }
            }
        });
        
        setVisible(true);
    }
}
