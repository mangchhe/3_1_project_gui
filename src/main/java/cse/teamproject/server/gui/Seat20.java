package cse.teamproject.server.gui;

import cse.teamproject.designpattern.factory.GuestRoom;
import cse.teamproject.designpattern.singleton.GuestRoomStorage;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * @author 하주현
 * 
 * 객실 상태를 간편하게 보여준다. SeatGui 객실을 35개 불러온다.
 * @since 2019-05-19
 *         2019-05-25 최신화 버튼 추가(파일 입출력 : 현재 객실상태를 파일에 저장)
 */

public class Seat20 extends JFrame{
    
    private Seat[] seatPan = new Seat[35];
    private JPanel seat20 = new JPanel();
    private int posXpanSeat, posYpanSeat;
    private JButton updateRoom;
    private GuestRoomStorage guestRoomStorage = GuestRoomStorage.getInstance();
    private GuestRoom[] guestRoom = guestRoomStorage.getStorage();
    private BufferedOutputStream bos;
    
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
        
        updateRoom = new JButton("객실 최신화");
        updateRoom.setBounds(620,20,125,45);
        
        updateRoom.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    for(int i=0;i<20;i++){
                        StringBuilder explanation = new StringBuilder();
                        bos = new BufferedOutputStream(new FileOutputStream("guestroomdb/"+i+".txt"));
                        explanation.append(guestRoom[i].getBed()+"\r\n");
                        explanation.append(guestRoom[i].getBlanket()+"\r\n");
                        explanation.append(guestRoom[i].getTowel()+"\r\n");
                        explanation.append(guestRoom[i].getPillow()+"\r\n");
                        bos.write(explanation.toString().getBytes());
                        bos.close();
                    }
                }catch(IOException o){
                    System.out.println("파일을 찾지 못하였습니다.");
                }
            }
        });

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
        layer.add(title,new Integer(2));
        layer.add(updateRoom,new Integer(3));
        add(layer);
        
    }
    
}