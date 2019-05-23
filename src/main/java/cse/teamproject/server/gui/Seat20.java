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

public class Seat20 extends JFrame{
    
    private Seat[] seatPan = new Seat[35];
    private JPanel seat20 = new JPanel();
    private int posXpanSeat, posYpanSeat;
    
    public Seat20(){
        
        setVisible(true);
        setSize(800,700);
        setTitle("ManagementView");
        Dimension frameSize = this.getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
        
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(null);
        layer.setBounds(0,0,800,700);
        
        JLabel title = new JLabel("객실관리");
        title.setBounds(310,-50,200,200);
        title.setFont(new Font("",Font.BOLD,40));
        title.setOpaque(false);
        add(title);

        seat20.setLayout(null);
        seat20.setBounds(40,100,800,700);
        seat20.setOpaque(false);
       
        // seat35
        for(int seat =0;seat<20;seat++){
            seatPan[seat] = new Seat(seat);
            if(seat % 4 ==0 && seat!=0){
                posXpanSeat = 0;
                posYpanSeat += 110;
            }
            seatPan[seat].setBounds(posXpanSeat, posYpanSeat, 140, 100);
            seat20.add(seatPan[seat]);
            posXpanSeat += 180;
        }
        
        ClockMessage clockMessage = new ClockMessage();
        clockMessage.setBounds(30,0,100,100);
        new Thread(clockMessage).start();
        
        layer.add(seat20,new Integer(0));
        layer.add(clockMessage,new Integer(1));
        add(layer);
        
    }
    
}