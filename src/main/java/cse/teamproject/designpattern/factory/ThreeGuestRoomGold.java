package cse.teamproject.designpattern.factory;

/**
 * @author 하주현
 * 
 * 골드 3인 객실 구성 셋팅
 * @since 2019-05-23
 */

class ThreeGuestRoomGold extends GuestRoom {
  public ThreeGuestRoomGold() {
    name="3인 객실[3]";
    room=2;
    restRoom=1;
    kitchen=1;
    pillow=3;
    blanket=3;
    bed=2;
    rank=3;
    towel=6;
    price=20000;
  }

}
