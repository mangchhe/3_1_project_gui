package cse.teamproject.designpattern.factory;

/**
 * @author 하주현
 * 
 * 다이아몬드 5인 객실 구성 셋팅
 * @since 2019-05-23
 */

class FiveGuestRoomDiamond extends GuestRoom {
  public FiveGuestRoomDiamond() {
    name="5인 객실[4]";
    room=3;
    restRoom=2;
    kitchen=1;
    pillow=5;
    blanket=5;
    bed=2;
    rank=4;
    towel=10;
    price=30000;
  }

}
