package cse.teamproject.designpattern.factory;

/**
 * @author 하주현
 * 
 * 골드 5인 객실 구성 셋팅
 * @since 2019-05-23
 */

class FiveGuestRoomGold extends GuestRoom {
  public FiveGuestRoomGold() {
    name="5인 객실[3]";
    room=3;
    restRoom=2;
    kitchen=1;
    pillow=5;
    blanket=5;
    bed=2;
    rank=3;
    towel=10;
    price=30000;
  }

}
