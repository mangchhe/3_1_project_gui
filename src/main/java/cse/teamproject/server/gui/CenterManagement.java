package cse.teamproject.server.gui;

import cse.teamproject.designpattern.factory.GuestRoom;
import cse.teamproject.designpattern.singleton.GuestRoomStorage;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
 * 로그인 하고 나서 관리자에게 메인프레임 띄워주는 화면
 * @since 2019-05-19
 *         2019-05-26 파일입출력 추가(끌 때 현재 좌석현황을 텍스트파일로 저장한다.)
 */

public class CenterManagement extends JFrame {
    
    private JButton btn,btn2,btn3;
    GuestRoomStorage guestRoomStorage = GuestRoomStorage.getInstance();
    GuestRoom[] guestRoom = guestRoomStorage.getStorage();
    BufferedOutputStream bos;

    public CenterManagement(){
        
        this.addWindowListener(new WindowAdapter(){
           public void windowClosing(WindowEvent e){
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
                    for(int i=0;i<20;i++){
                        StringBuilder state = new StringBuilder();
                        boolean[] isstate = new boolean[30];
                        bos = new BufferedOutputStream(new FileOutputStream("reservationState/"+i+".txt"));
                        isstate=guestRoom[i].getState();
                        for(int j=0;j<30;j++){
                            state.append(isstate[j]+"\r\n");
                        }
                        bos.write(state.toString().getBytes());
                        bos.close();
                    }
                    for(int i=0;i<20;i++){
                        bos = new BufferedOutputStream(new FileOutputStream("guestRoomExplanation/"+i+".txt"));
                        bos.write(guestRoom[i].toString().getBytes());
                        bos.close();
                    }
                }catch(IOException o){
                    System.out.println("파일을 찾지 못하였습니다.");
                }
                System.exit(0);
           }
        });
        
        setSize(650,450);
        setTitle("ManagementView");
        setLocationRelativeTo(null);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,800,600);
        layeredPane.setLayout(null);
                
        // 메인 배경화면
        JPanel panel = new Background();
        panel.setLayout(null);
        panel.setBounds(15,5,600,400);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(15,5,600,400);
        panel2.setOpaque(false);
        
        btn = new JButton("객실 확인");
        btn.setBounds(120,80,120,35);
        panel2.add(btn);
        
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Seat20();
            }
        });
        
        btn2 = new JButton("예약자 관리");
        btn2.setBounds(260,80,120,35);
        panel2.add(btn2);
        
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new BookerManagement();
            }
        });
        
        btn3 = new JButton("비품 재고");
        btn3.setBounds(400,80,120,35);
        panel2.add(btn3);
        
        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new InventoryManagement();
            }
        });
        
        // 제목
        JLabel title = new JLabel("관리 시스템");
        title.setBounds(230,-80,250,200);
        title.setFont(new Font("",Font.BOLD,30));
        title.setOpaque(false);
        panel.add(title);
        
        // 시계 이미지  
        ClockMessage clockMessage = new ClockMessage();
        clockMessage.setBounds(30,0,100,100);
        new Thread(clockMessage).start();
        
        layeredPane.add(panel,new Integer(0));
        layeredPane.add(panel2,new Integer(1));
        layeredPane.add(clockMessage,new Integer(2));
        
        add(layeredPane);
        setVisible(true);
        
        // 관리자 채팅
        new MessageManagement();
        
    }
    
    class Background extends JPanel{
        Image img;
        public Background(){
            img = Toolkit.getDefaultToolkit().createImage("img/MainView.png");
        }
        public void paint(Graphics g){
            super.paint(g);
            g.drawImage(img, 0, 0, this);
        }
    }
    
}
