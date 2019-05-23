package cse.teamproject.designpattern.factory;

/**
 * @author 하주현
 * 
 * 등급에 맞는 2인 객실 객체 반환
 * @since 2019-05-23
 */

class TwoGuestRoomBuild extends GuestRoomBuild {
    public GuestRoom createGuestRoom(String type){
        if(type.equals("Bronze")){
            return new TwoGuestRoomBronze();
        }
        else if(type.equals("Silver")){
            return new TwoGuestRoomSilver();
        }
        else if(type.equals("Gold")){
            return new TwoGuestRoomGold();
        }
        else if(type.equals("Diamond")){
            return new TwoGuestRoomDiamond();
        }
        else{
            return null;
        }
    }
}
