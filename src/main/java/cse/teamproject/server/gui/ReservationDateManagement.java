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
 * 요일별로 예약 현황 보여주는 창
 * @since 2019-05-26
 */

public class ReservationDateManagement extends JFrame {
    
    private Date[] datePan = new Date[30];
    private JPanel date30 = new JPanel();
    private int posXpanSeat=900, posYpanSeat;
    private int color;
        
    public ReservationDateManagement(int clickNum){
        
        setSize(1150,800);
        setTitle("ManagementView");
        Dimension frameSize = this.getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
        
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(null);
        layer.setBounds(0,0,1150,800);
        
        JLabel title = new JLabel("예약 목록");
        title.setBounds(450,-50,200,200);
        title.setFont(new Font("",Font.BOLD,40));
        title.setOpaque(false);

        date30.setLayout(null);
        date30.setBounds(40,100,1150,800);
        date30.setOpaque(false);
       
        // seat35
        for(int seat=0;seat<30;seat++){
            if(seat==0||seat==7||seat==14||seat==21||seat==28){
                color=1;
            }else if(seat==1||seat==8||seat==15||seat==22||seat==29){
                color=2;
            }else{
                color=0;
            }
            datePan[seat] = new Date(seat, color, clickNum);
            if(seat==1||seat==8||seat==15||seat==22||seat==29){
                posXpanSeat = 0;
                posYpanSeat += 110;
            }
            datePan[seat].setBounds(posXpanSeat, posYpanSeat, 140, 100);
            date30.add(datePan[seat]);
            posXpanSeat += 150;
        }
        
        ClockMessage clockMessage = new ClockMessage();
        clockMessage.setBounds(30,0,100,100);
        new Thread(clockMessage).start();
        
        layer.add(date30,new Integer(0));
        layer.add(clockMessage,new Integer(1));
        layer.add(title,new Integer(2));
        add(layer);
        
        setVisible(true);
    }
}
