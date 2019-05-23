package cse.teamproject.designpattern.factory;

/**
 * @author 하주현
 * 
 * 각 등급별 객실 객체 생성후 저장소로 이용
 * @since 2019-05-23
 */

public class GuestRoomStorage {
    public static GuestRoomBuild oneRoom = new OneGuestRoomBuild();
    public static GuestRoomBuild twoRoom = new TwoGuestRoomBuild();
    public static GuestRoomBuild threeRoom = new ThreeGuestRoomBuild();
    public static GuestRoomBuild fourRoom = new FourGuestRoomBuild();
    public static GuestRoomBuild fiveRoom = new FiveGuestRoomBuild();
    public static GuestRoom[] guestRoom = new GuestRoom[20];
    
    public static void main(String[] args){
        
        guestRoom[0]=oneRoom.selectGuestRoom("Bronze");
        guestRoom[1]=oneRoom.selectGuestRoom("Silver");
        guestRoom[2]=oneRoom.selectGuestRoom("Gold");
        guestRoom[3]=oneRoom.selectGuestRoom("Diamond");
        
        guestRoom[4]=twoRoom.selectGuestRoom("Bronze");
        guestRoom[5]=twoRoom.selectGuestRoom("Silver");
        guestRoom[6]=twoRoom.selectGuestRoom("Gold");
        guestRoom[7]=twoRoom.selectGuestRoom("Diamond");
        
        guestRoom[8]=threeRoom.selectGuestRoom("Bronze");
        guestRoom[9]=threeRoom.selectGuestRoom("Silver");
        guestRoom[10]=threeRoom.selectGuestRoom("Gold");
        guestRoom[11]=threeRoom.selectGuestRoom("Diamond");
        
        guestRoom[12]=fourRoom.selectGuestRoom("Bronze");
        guestRoom[13]=fourRoom.selectGuestRoom("Silver");
        guestRoom[14]=fourRoom.selectGuestRoom("Gold");
        guestRoom[15]=fourRoom.selectGuestRoom("Diamond");
        
        guestRoom[16]=fiveRoom.selectGuestRoom("Bronze");
        guestRoom[17]=fiveRoom.selectGuestRoom("Silver");
        guestRoom[18]=fiveRoom.selectGuestRoom("Gold");
        guestRoom[19]=fiveRoom.selectGuestRoom("Diamond");
        
        System.out.println(guestRoom[0].explanation);
        System.out.println(guestRoom[5].explanation);
        System.out.println(guestRoom[9].explanation);
        
        
    }
}
