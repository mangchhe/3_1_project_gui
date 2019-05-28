package cse.teamproject.client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Seat extends JPanel {
    private BufferedImage img = null;
    private JLabel label = new JLabel();
    private int numSeat;
    
    public Seat(int numSeat){
        
        this.numSeat = numSeat;
        
        if(numSeat<4){
            img("5");
        }
        else if(numSeat<8){
            img("4");
        }
        else if(numSeat<12){
            img("3");
        }
        else if(numSeat<16){
            img("2");
        }
        else{
            img("1");
        }
        setLayout(null);
        
        JPanel panImg = new InnerPanel();
        panImg.setBounds(0,0,140,100);
        panImg.setOpaque(false);
        
        JPanel panContent = new JPanel();
        panContent.setLayout(null);
        panContent.setBounds(0,0,140,100);
        
        label = new JLabel((numSeat + 1)+". 빈방");
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
        
        SeatListener listener = new SeatListener(numSeat);
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

class SeatListener implements MouseListener{
    int clickNum;
    BufferedReader br;
    boolean[] temp = new boolean[30];
    public SeatListener(int numSeat){
        clickNum=numSeat;
    }
    
    public void mouseClicked(MouseEvent e){} // 클릭하였을 때
    public void mousePressed(MouseEvent e){} // 마우스 누를때
    public void mouseReleased(MouseEvent e){ // 마우스 뗄때
         try{
             int count=0;
             br = new BufferedReader(new FileReader("reservationStateClient/"+clickNum+".txt"));
             while(true){
                 String line = br.readLine();
                 if(line==null){
                     br.close();
                     break;
                 }
                 temp[count]=Boolean.parseBoolean(line);
                 count++;
             }
         }catch(IOException o){
             System.out.println("파일을 찾지 못하였습니다.");
         }
        new ReservationBridge(clickNum,temp);
    }
    public void mouseEntered(MouseEvent e){} // 컴포넌트 올라갈 때
    public void mouseExited(MouseEvent e){}  // 컴포넌트 나갈 때
}