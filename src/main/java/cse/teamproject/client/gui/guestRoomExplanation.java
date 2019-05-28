package cse.teamproject.client.gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class guestRoomExplanation extends JFrame {
    
    BufferedReader br;
    StringBuilder explanation = new StringBuilder();
    JLabel explanationLabel;
    
    public guestRoomExplanation(int clickNum){
        
        setTitle("객실 정보");
        setSize(210,260);
        setLocationRelativeTo(null);
        setLayout(null);
        
         try{
             br = new BufferedReader(new FileReader("guestRoomExplanationClient/"+clickNum+".txt"));
             explanation.append("<html>");
             while(true){
                 String line = br.readLine();
                 if(line==null){
                     br.close();
                     break;
                 }
                 explanation.append(line+"<br>");
             }
             explanation.append("</html>");
         }catch(IOException o){
             System.out.println("파일을 찾지 못하였습니다.");
         }
         explanationLabel = new JLabel(explanation.toString());
         explanationLabel.setBounds(20,-20,260,260);
         add(explanationLabel);
        
        setVisible(true);
        
    }
}
