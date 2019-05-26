package cse.teamproject.server.gui;

import cse.teamproject.designpattern.factory.GuestRoom;
import cse.teamproject.designpattern.singleton.GuestRoomStorage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * @author 하주현
 * 
 * 날짜를 나타내는 프레임
 * @since 2019-05-26
 */

public class Date extends JPanel {
    private BufferedImage img = null;
    private JLabel label = new JLabel();
    private int numSeat;
    GuestRoomStorage guestRoomStorage = GuestRoomStorage.getInstance();
    GuestRoom[] guestRoom = guestRoomStorage.getStorage();
    boolean[] isGuestRoom;
    
    public Date(int numSeat, int color, int clickNum){
        
        this.numSeat = numSeat;
        isGuestRoom = guestRoom[clickNum].getState();
        
        if(color==0&&!isGuestRoom[numSeat]){
            img("5_o");
        }
        else if(color==0&&isGuestRoom[numSeat]){
            img("5_x");
        }
        else if(color==1&&!isGuestRoom[numSeat]){
            img("2_o");
        }
        else if(color==1&&isGuestRoom[numSeat]){
            img("2_x");
        }
        else if(color==2&&!isGuestRoom[numSeat]){
            img("4_o");
        }
        else{
            img("4_x");
        }
                
        setLayout(null);
        
        JPanel panImg = new InnerPanel();
        panImg.setBounds(0,0,140,100);
        panImg.setOpaque(false);
        
        JPanel panContent = new JPanel();
        panContent.setLayout(null);
        panContent.setBounds(0,0,140,100);
        
        if(numSeat%7==0){
            label = new JLabel((numSeat + 1)+". 토요일");
        }
        else if(numSeat%7==1){
            label = new JLabel((numSeat + 1)+". 일요일");
        }
        else if(numSeat%7==2){
            label = new JLabel((numSeat + 1)+". 월요일");
        }
        else if(numSeat%7==3){
            label = new JLabel((numSeat + 1)+". 화요일");
        }
        else if(numSeat%7==4){
            label = new JLabel((numSeat + 1)+". 수요일");
        }
        else if(numSeat%7==5){
            label = new JLabel((numSeat + 1)+". 목요일");
        }
        else{
            label = new JLabel((numSeat + 1)+". 금요일");
        }
        
        label.setBounds(15,15,80,20);
        label.setForeground(new Color(0,0,0));
        label.setFont(new Font("",Font.BOLD,12));
        panContent.add(label);
        panContent.setOpaque(false);
        
        JLayeredPane layered = new JLayeredPane();
        layered.setBounds(0,0,1200,760);
        layered.setLayout(null);
        layered.setOpaque(false);
        layered.add(panImg,new Integer(0));
        layered.add(panContent,new Integer(1));
        
        DateListener listener = new DateListener();
        layered.addMouseListener(listener);
        
        add(layered);
        
        setVisible(true);
        setOpaque(false);
        setFocusable(true);
    }
    
    class InnerPanel extends JPanel {
        @Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img, 0, 0, null);
	}
    }
    
    public void img(String filename) {
	try {
		img = ImageIO.read(new File("img/" + filename + ".png"));
	} catch (IOException e) {
		System.out.println("이미지 불러오기 실패");
		System.exit(0);
	}
	repaint();
    }
}

class DateListener implements MouseListener{
        public void mouseClicked(MouseEvent e){} // 클릭하였을 때
        public void mousePressed(MouseEvent e){} // 마우스 누를때
        public void mouseReleased(MouseEvent e){ // 마우스 뗄때
        }
        public void mouseEntered(MouseEvent e){} // 컴포넌트 올라갈 때
        public void mouseExited(MouseEvent e){}  // 컴포넌트 나갈 때
}