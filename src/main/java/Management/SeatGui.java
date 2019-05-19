package Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class SeatGui extends JPanel {
    private BufferedImage img = null;
    JLabel label = new JLabel();
    private int numSeat;
    
    public SeatGui(int numSeat){
        
        this.numSeat = numSeat;
        if(numSeat<7){
            img("5");
        }
        else if(numSeat<14){
            img("4");
        }
        else if(numSeat<21){
            img("3");
        }
        else if(numSeat<28){
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