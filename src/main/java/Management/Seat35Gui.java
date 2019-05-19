package Management;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Seat35Gui extends JFrame{
    
    SeatGui[] seatPan = new SeatGui[35];   //  멀티
    JPanel seat35 = new JPanel();   //  멀티
    int posXpanSeat, posYpanSeat;
    
    public Seat35Gui(){
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
            seatPan[seat] = new SeatGui(seat);
            if(seat % 7 ==0 && seat!=0){
                posXpanSeat = 0;
                posYpanSeat += 110;
            }
            seatPan[seat].setBounds(posXpanSeat, posYpanSeat, 140, 100);
            seat35.add(seatPan[seat]);
            posXpanSeat += 160;
        }
        
        ClockMessageGui clockMessage = new ClockMessageGui();
        clockMessage.setBounds(30,0,100,100);
        new Thread(clockMessage).start();
        
        layer.add(seat35,new Integer(0));
        layer.add(clockMessage,new Integer(1));
        add(layer);
        
    }
    
}
