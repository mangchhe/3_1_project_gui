package cse.teamproject.client.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class guestRoomStatusView extends JFrame{
    
    private Seat[] seatPan = new Seat[20];
    private JPanel seat20 = new JPanel();
    private int posXpanSeat, posYpanSeat;
    
    public guestRoomStatusView(){
        
        setSize(800,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("ManagementView");
        Dimension frameSize = this.getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
        
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(null);
        layer.setBounds(0,0,800,700);
        
        JLabel title = new JLabel("객실정보");
        title.setBounds(310,-50,200,200);
        title.setFont(new Font("",Font.BOLD,40));
        title.setOpaque(false);

        seat20.setLayout(null);
        seat20.setBounds(40,100,800,700);
        seat20.setOpaque(false);
       
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
        layer.add(title,new Integer(2));
        add(layer);
        
        new MessageManagement();
        
        setVisible(true);
    }
}