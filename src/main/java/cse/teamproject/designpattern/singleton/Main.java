package cse.teamproject.designpattern.singleton;

import cse.teamproject.designpattern.factory.GuestRoom;

/**
 * @author 하주현
 * 
 * 싱글톤 적용되었는지 테스트
 * @since 2019-05-25
 */

public class Main {
    
    public static void main(String[] args){
        //GuestRoomStorage guesetRoomStorage = new GuestRoomStorage(); // 싱글톤 적용 확인 작업
        GuestRoomStorage a=GuestRoomStorage.getInstance();
        GuestRoomStorage b=GuestRoomStorage.getInstance();
        GuestRoom[] guestRoom = a.getStorage();
        GuestRoom[] guestRoom2 = b.getStorage();
        
        if(a==b&&guestRoom[0]==guestRoom2[0]){  // 싱글톤이 적용되었는지 확인 작업
            System.out.println("같다");
        }
        else{
            System.out.println("다르다");
        }
        //System.out.println(guestRoom[0].pillow);  // 싱글톤이 적용되었는지 확인 작업
        //guestRoom[0].permutePillow();
        //System.out.println(guestRoom2[0].pillow);
        //System.out.println(guestRoom[18].pillow);
        //guestRoom[18].permutePillow();
        //System.out.println(guestRoom[18].pillow);
        //System.out.println(guestRoom[0].getBed());// 파일 입출력 확인
        //System.out.println(guestRoom[0].getBlanket());
        //System.out.println(guestRoom[0].getTowel());
        //System.out.println(guestRoom[0].getPillow());
        //System.out.println(guestRoom[2].getBed());
        //System.out.println(guestRoom[2].getBlanket());
        //System.out.println(guestRoom[2].getTowel());
        //System.out.println(guestRoom[2].getPillow());
        
    }
}
