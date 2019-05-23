package cse.teamproject.designpattern.factory;

/**
 * @author 하주현
 * 
 * 생성하기 위한 객체의 종류를 받아 생성 후 반환(추상클래스)
 * @since 2019-05-23
 */

public abstract class GuestRoomBuild {
    
    public abstract GuestRoom createGuestRoom(String type);
    
    public GuestRoom selectGuestRoom(String type){
        GuestRoom guestRoom = createGuestRoom(type);
        System.out.println("뚝딱뚝딱 객실을 만들자..\n");
        return guestRoom;
    }
}
