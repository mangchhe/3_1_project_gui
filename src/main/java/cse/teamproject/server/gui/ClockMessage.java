package cse.teamproject.server.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author 하주현
 * 
 * 현재 시간을 보여주는 Panel / 쓰레드를 이용한 최신화
 * @since 2019-05-19
 */

class ClockMessage extends JPanel implements Runnable{
    
    private Calendar today = Calendar.getInstance();
    private int i = today.get(Calendar.AM_PM);
    private SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
    private String time = sdf.format(new Date());
    private JLabel timeLabel, ampmLabel;
    private String[] ampm = {"AM", "PM"};
    public ClockMessage(){
         this.setLayout(null);
         timeLabel = new JLabel(time);
         timeLabel.setBounds(0,0,100,70);
         timeLabel.setFont(new Font("",Font.BOLD, 25));
         timeLabel.setForeground(new Color(170,170,170));
          
         ampmLabel = new JLabel(ampm[i]);
         ampmLabel.setBounds(33,0,100,110);
         ampmLabel.setFont(new Font("",Font.BOLD, 20));
         ampmLabel.setForeground(new Color(170,170,170));
          
         add(timeLabel, BorderLayout.NORTH);
         add(ampmLabel, BorderLayout.CENTER);
     }
     public void run(){
         do{
             try{
                 Thread.sleep(1000);
             }catch(InterruptedException e){
                 e.printStackTrace();
             }
             timeLabel.setText(sdf.format(new Date()));
         }while(true);
     }
 }