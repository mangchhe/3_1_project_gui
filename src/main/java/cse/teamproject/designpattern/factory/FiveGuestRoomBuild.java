package cse.teamproject.designpattern.factory;

/**
 * @author 하주현
 * 
 * 등급에 맞는 5인 객실 객체 반환
 * @since 2019-05-23
 */

class FiveGuestRoomBuild extends GuestRoomBuild {
    public GuestRoom createGuestRoom(String type){
        if(type.equals("Bronze")){
            return new FiveGuestRoomBronze();
        }
        else if(type.equals("Silver")){
            return new FiveGuestRoomSilver();
        }
        else if(type.equals("Gold")){
            return new FiveGuestRoomGold();
        }
        else if(type.equals("Diamond")){
            return new FiveGuestRoomDiamond();
        }
        else{
            return null;
        }
    }
}
