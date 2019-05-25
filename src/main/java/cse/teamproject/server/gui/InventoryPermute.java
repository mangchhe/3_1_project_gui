package cse.teamproject.server.gui;

import cse.teamproject.designpattern.factory.GuestRoom;
import cse.teamproject.designpattern.singleton.GuestRoomStorage;
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
 * 변경 하고자 하는 비품 입력 하는 창
 * @since 2019-05-26
 */

public class InventoryPermute extends JFrame {
    GuestRoomStorage guestRoomStorage = GuestRoomStorage.getInstance();
    GuestRoom[] guestRoom = guestRoomStorage.getStorage();
    
    JLabel guestRoomNum, inventoryName, permuteNum;
    JTextField guestRoomValue, inventoryValue, permuteValue;
    JButton confirm;
    
    public InventoryPermute(){
        setTitle("재고 변경");
        setSize(300,170);
        setLocationRelativeTo(null);
        setLayout(null);
        
        guestRoomNum = new JLabel("객실 번호");
        guestRoomNum.setBounds(30,30,70,20);
        add(guestRoomNum);
        
        guestRoomValue = new JTextField();
        guestRoomValue.setBounds(42,60,30,20);
        add(guestRoomValue);
        
        inventoryName = new JLabel("비품 번호");
        inventoryName.setBounds(115,30,70,20);
        add(inventoryName);
        
        inventoryValue = new JTextField();
        inventoryValue.setBounds(127,60,30,20);
        add(inventoryValue);
        
        permuteNum = new JLabel("변경 갯수");
        permuteNum.setBounds(200,30,70,20);
        add(permuteNum);
        
        permuteValue = new JTextField();
        permuteValue.setBounds(212,60,30,20);
        add(permuteValue);
        
        confirm = new JButton("변경");
        confirm.setBounds(103,100,80,20);
        add(confirm);
        
        confirm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Integer.parseInt(inventoryValue.getText())==0){
                    guestRoom[Integer.parseInt(guestRoomValue.getText())-1].setTowel(Integer.parseInt(permuteValue.getText()));
                }
                else if(Integer.parseInt(inventoryValue.getText())==1){
                    guestRoom[Integer.parseInt(guestRoomValue.getText())-1].setPillow(Integer.parseInt(permuteValue.getText()));
                }
                else if(Integer.parseInt(inventoryValue.getText())==2){
                    guestRoom[Integer.parseInt(guestRoomValue.getText())-1].setBlanket(Integer.parseInt(permuteValue.getText()));
                }
                else if(Integer.parseInt(inventoryValue.getText())==3){
                    guestRoom[Integer.parseInt(guestRoomValue.getText())-1].setBed(Integer.parseInt(permuteValue.getText()));
                }
                else{
                    JOptionPane.showMessageDialog(null, "0 : 수건 // 1 : 베개 // 2 : 이불 // 3 : 침대 중에 선택해주세요.");
                }
            }
        });
        
        setVisible(true);
    }
    
}
