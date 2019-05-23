package cse.teamproject.designpattern.factory;

/**
 * @author 하주현
 * 
 * 등급에 맞는 1인 객실 객체 반환
 * @since 2019-05-23
 */

public class OneGuestRoomBuild extends GuestRoomBuild{
    public GuestRoom createGuestRoom(String type){
        if(type.equals("Bronze")){
            return new OneGuestRoomBronze();
        }
        else if(type.equals("Silver")){
            return new OneGuestRoomSilver();
        }
        else if(type.equals("Gold")){
            return new OneGuestRoomGold();
        }
        else if(type.equals("Diamond")){
            return new OneGuestRoomDiamond();
        }
        else{
            return null;
        }
    }
}
