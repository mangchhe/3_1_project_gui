package cse.teamproject.server.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * @author 하주현
 * 
 * 객실 상태를 간편하게 보여준다. SeatGui 객실을 35개 불러온다.
 * @since 2019-05-19
 */

public class Seat35 extends JFrame{
    
    Seat[] seatPan = new Seat[35];
    JPanel seat35 = new JPanel();
    int posXpanSeat, posYpanSeat;
    
    public Seat35(){
        
        setVisible(true);
        setSize(1200,760);
        setTitle("ManagementView");
        Dimension frameSize = this.getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
        
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(null);
        layer.setBounds(0,0,1200,760);
        
        JLabel title = new JLabel("객실관리");
        title.setBounds(510,-50,200,200);
        title.setFont(new Font("",Font.BOLD,40));
        title.setOpaque(false);
        add(title);

        seat35.setLayout(null);
        seat35.setBounds(40,120,1200,760);
        seat35.setOpaque(false);
       
        // seat35
        for(int seat =0;seat<35;seat++){
            seatPan[seat] = new Seat(seat);
            if(seat % 7 ==0 && seat!=0){
                posXpanSeat = 0;
                posYpanSeat += 110;
            }
            seatPan[seat].setBounds(posXpanSeat, posYpanSeat, 140, 100);
            seat35.add(seatPan[seat]);
            posXpanSeat += 160;
        }
        
        ClockMessage clockMessage = new ClockMessage();
        clockMessage.setBounds(30,0,100,100);
        new Thread(clockMessage).start();
        
        layer.add(seat35,new Integer(0));
        layer.add(clockMessage,new Integer(1));
        add(layer);
        
    }
    
}
