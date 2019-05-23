package cse.teamproject.designpattern.factory;

/**
 * @author 하주현
 * 
 * 등급에 맞는 3인 객실 객체 반환
 * @since 2019-05-23
 */

class ThreeGuestRoomBuild extends GuestRoomBuild {
    public GuestRoom createGuestRoom(String type){
        if(type.equals("Bronze")){
            return new ThreeGuestRoomBronze();
        }
        else if(type.equals("Silver")){
            return new ThreeGuestRoomSilver();
        }
        else if(type.equals("Gold")){
            return new ThreeGuestRoomGold();
        }
        else if(type.equals("Diamond")){
            return new ThreeGuestRoomDiamond();
        }
        else{
            return null;
        }
    }
}
