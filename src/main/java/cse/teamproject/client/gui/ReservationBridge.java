package cse.teamproject.client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ReservationBridge extends JFrame {
    
    private JButton reservationBtn, explanationBtn;
    
    public ReservationBridge(int clickNum, boolean[] seatState){
        
        setTitle("객실 정보 선택");
        setSize(200,180);
        setLocationRelativeTo(null);
        setLayout(null);
        
        reservationBtn = new JButton("예약하기");
        reservationBtn.setBounds(45,30,100,30);
        add(reservationBtn);

        reservationBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new ReservationDateView(seatState);
            }
        });
        
        explanationBtn = new JButton("객실정보");
        explanationBtn.setBounds(45,80,100,30);
        add(explanationBtn);
        
        explanationBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new guestRoomExplanation(clickNum);
            }
        });
        
        setVisible(true);
    }
    
}
