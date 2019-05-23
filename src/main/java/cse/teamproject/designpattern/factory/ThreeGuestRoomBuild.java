package cse.teamproject.designpattern.factory;

class ThreeGuestRoomBuild extends GuestRoomBuild {
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
