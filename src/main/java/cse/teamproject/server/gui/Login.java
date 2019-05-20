package cse.teamproject.server.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author 하주현
 * 
 * 관리자가 로그인 할 수 있는 창
 * @since 2019-05-20
 */

public class Login extends JFrame{
    BufferedImage img = null;
    JTextField loginTextField;
    JPasswordField passwordField;
    JButton btm, btm2;
    
    public static void main(String[] args){
        new Login();
    }
    
    public Login(){
        
        setTitle("로그인 화면");
        setSize(415,640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        try{
            img = ImageIO.read(new File("img/login.png"));
        }catch(IOException e){
            System.out.println("이미지 불러오기 실패");
            System.exit(0);
        }
        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 400, 600);
        layeredPane.setLayout(null);
        
        MyPanel panel = new MyPanel();
        panel.setBounds(0,0,400,600);
        
        loginTextField = new JTextField(15);
        loginTextField.setHorizontalAlignment(JTextField.CENTER);
        loginTextField.setBounds(140,410,120,25);
        loginTextField.setOpaque(false);
    //    loginTextField.setForeground(Color.green);
        loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        layeredPane.add(loginTextField);
        
        passwordField = new JPasswordField();
        passwordField.setHorizontalAlignment(JTextField.CENTER);
        passwordField.setBounds(140,475,120,25);
        passwordField.setOpaque(false);
    //    passwordField.setForeground(Color.green);
        passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        layeredPane.add(passwordField);
        
        btm = new JButton(new ImageIcon("img/loginButton.png"));
        btm.setBounds(115,530,160,40);
        btm.setBorderPainted(false);
        btm.setFocusPainted(false);
        btm.setContentAreaFilled(false);
        layeredPane.add(btm);
        /*
            로그인 버튼을 눌렀을 때
        */
        ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String id = loginTextField.getText();
                char[] pass = passwordField.getPassword();
                String password = new String(pass);
        
                if(id.equals("") || password.equals("")){
                    JOptionPane.showMessageDialog(null, "빈칸을 채워주세요.");
                }else{
                //    boolean existLogin = LoginService.LogintTest(id, password);
                    boolean existLogin;
                    if(id.equals("mangchhe")&&password.equals("1234")){
                        existLogin=true;
                    }
                    else{
                        existLogin=false;
                    }
            
                    if(existLogin){
                        JOptionPane.showMessageDialog(null, "Login Success");
                        new CenterManagement();
                    }else{
                        JOptionPane.showMessageDialog(null, "Login Fail");
                    }
                 }                
            }
        };
        btm.addActionListener(listener);
        
        btm2 = new JButton(new ImageIcon("img/register.png"));
        btm2.setBounds(310,560,80,25);
        btm2.setBorderPainted(false);
        btm2.setFocusPainted(false);
        btm2.setContentAreaFilled(false);
        layeredPane.add(btm2);
        /*
            회원가입 버튼을 눌렀을 때
        */
        ActionListener listener2 = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Register();
            }
        };
        btm2.addActionListener(listener2);
        
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
