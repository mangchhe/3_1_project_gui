package cse.teamproject.designpattern.factory;

/**
 * @author 하주현
 * 
 * 등급에 맞는 4인 객실 객체 반환
 * @since 2019-05-23
 */

class FourGuestRoomBuild extends GuestRoomBuild {
    public GuestRoom createGuestRoom(String type){
        if(type.equals("Bronze")){
            return new FourGuestRoomBronze();
        }
        else if(type.equals("Silver")){
            return new FourGuestRoomSilver();
        }
        else if(type.equals("Gold")){
            return new FourGuestRoomGold();
        }
        else if(type.equals("Diamond")){
            return new FourGuestRoomDiamond();
        }
        else{
            return null;
        }
    }
}
