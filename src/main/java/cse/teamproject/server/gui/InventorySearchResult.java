package cse.teamproject.server.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import cse.teamproject.designpattern.factory.GuestRoom;
import cse.teamproject.designpattern.singleton.GuestRoomStorage;

/**
 * @author 하주현
 * 
 * 찾고자 하는 객실의  비품 갯수 결과창
 * @since 2019-05-26
 */

public class InventorySearchResult extends JFrame {
    
    JLabel pillow, blanket, towel, bed, pillowValue, blanketValue, towelValue, bedValue;
    GuestRoomStorage guestRoomStorage = GuestRoomStorage.getInstance();
    GuestRoom[] guestRoom = guestRoomStorage.getStorage();

    public InventorySearchResult(int selectGuestRoom){
        setTitle("재고 검색 결과");
        setSize(300,170);
        setLocationRelativeTo(null);
        setLayout(null);
        
        blanket = new JLabel("이불");
        blanket.setBounds(50,30,30,20);
        add(blanket);
        
        blanketValue = new JLabel(String.valueOf(guestRoom[selectGuestRoom].getBlanket()));
        blanketValue.setBounds(60,70,30,20);
        add(blanketValue);
        
        towel = new JLabel("수건");
        towel.setBounds(100,30,30,20);
        add(towel);
        
        towelValue = new JLabel(String.valueOf(guestRoom[selectGuestRoom].getTowel()));
        towelValue.setBounds(110,70,30,20);
        add(towelValue);
        
        bed = new JLabel("침대");
        bed.setBounds(150,30,30,20);
        add(bed);
        
        bedValue = new JLabel(String.valueOf(guestRoom[selectGuestRoom].getBed()));
        bedValue.setBounds(160,70,30,20);
        add(bedValue);
        
        pillow = new JLabel("베개");
        pillow.setBounds(200,30,30,20);
        add(pillow);
        
        pillowValue = new JLabel(String.valueOf(guestRoom[selectGuestRoom].getPillow()));
        pillowValue.setBounds(210,70,30,20);
        add(pillowValue);
        
        setVisible(true);
    }
}
