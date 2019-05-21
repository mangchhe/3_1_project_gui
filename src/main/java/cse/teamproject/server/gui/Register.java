package cse.teamproject.server.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @author 하주현
 * 
 * 회원가입 할 수 있는 창
 * @since 2019-05-20
 */

public class Register extends JFrame {
    
    BufferedImage img = null;
    
    private JButton btm,btm2,btm3;
    private JLabel jlb,jlb2,jlb3,jlb4,jlb5,jlb6,jlb7;
    private JTextField tfd,tfd2,tfd3,tfd4,tfd5,tfd6,tfd7;
    private JRadioButton jrb,jrb2;
    
    public Register(){
        setTitle("회원가입");
        setSize(415,640);
        setLocationRelativeTo(null);
        setLayout(null);
        
        try{
            img = ImageIO.read(new File("img/registerFrame.png"));
        }catch(IOException e){
            System.out.println("이미지 불러오기 실패");
            System.exit(0);
        }
        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 400, 600);
        layeredPane.setLayout(null);
        
        MyPanel panel = new MyPanel();
        panel.setBounds(0,0,400,600);
        
        jlb = new JLabel("아이디");
        jlb.setBounds(34, 79, 142, 18);
        jlb.setFont(new Font("굴림", Font.BOLD, 14));
        jlb.setForeground(Color.WHITE);
        layeredPane.add(jlb);
        
        tfd = new JTextField();
        tfd.setBounds(124,79,142,18);
        layeredPane.add(tfd);
        
        btm3=new JButton("중복확인");
        btm3.setBounds(284,79,88,18);
        layeredPane.add(btm3);
        
        jlb2 = new JLabel("이름");
        jlb2.setBounds(34, 139, 142, 18);
        jlb2.setFont(new Font("굴림", Font.BOLD, 14));
        jlb2.setForeground(Color.WHITE);
        layeredPane.add(jlb2);
        
        tfd2 = new JTextField();
        tfd2.setBounds(124,139,142,18);
        layeredPane.add(tfd2);
        
        jlb3 = new JLabel("성별");
        jlb3.setBounds(34, 189, 142, 18);
        jlb3.setFont(new Font("굴림", Font.BOLD, 14));
        jlb3.setForeground(Color.WHITE);
        layeredPane.add(jlb3);
        
        jrb = new JRadioButton("남");
        jrb.setBackground(new Color(248,222,0));
        jrb.setBounds(124,189,40,18);
        layeredPane.add(jrb);
        
        jrb2 = new JRadioButton("여");
        jrb2.setBackground(new Color(248,222,0));
        jrb2.setBounds(164,189,40,18);
        layeredPane.add(jrb2);
        
        jlb4 = new JLabel("암호");
        jlb4.setBounds(34, 239, 142, 18);
        jlb4.setFont(new Font("굴림", Font.BOLD, 14));
        jlb4.setForeground(Color.WHITE);
        layeredPane.add(jlb4);
        
        tfd3 = new JTextField();
        tfd3.setBounds(124,239,142,18);
        layeredPane.add(tfd3);
        
        jlb5 = new JLabel("암호 확인");
        jlb5.setBounds(34, 289, 142, 18);
        jlb5.setFont(new Font("굴림", Font.BOLD, 14));
        jlb5.setForeground(Color.WHITE);
        layeredPane.add(jlb5);
        
        tfd4 = new JTextField();
        tfd4.setBounds(124,289,142,18);
        layeredPane.add(tfd4);
        
        jlb6 = new JLabel("이메일");
        jlb6.setBounds(34, 339, 142, 18);
        jlb6.setFont(new Font("굴림", Font.BOLD, 14));
        jlb6.setForeground(Color.WHITE);
        layeredPane.add(jlb6);
        
        tfd5 = new JTextField();
        tfd5.setBounds(124,339,142,18);
        layeredPane.add(tfd5);
        
        jlb7 = new JLabel("자기소개");
        jlb7.setBounds(34, 389, 142, 18);
        jlb7.setFont(new Font("굴림", Font.BOLD, 14));
        jlb7.setForeground(Color.WHITE);
        layeredPane.add(jlb7);
        
        tfd6 = new JTextField();
        tfd6.setBounds(124,389,230,90);
        layeredPane.add(tfd6);
        
        btm=new JButton("확인");
        btm.setBounds(20,530,160,40);
        layeredPane.add(btm);
        
        btm2=new JButton("취소");
        btm2.setBounds(215,530,160,40);
        layeredPane.add(btm2);
        
        layeredPane.add(panel);
        add(layeredPane);
        setVisible(true);
    }
    
    class MyPanel extends JPanel{
        public void paint(Graphics g){
            g.drawImage(img, 0, 0, null);
        }
    }
}