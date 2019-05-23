package cse.teamproject.designpattern.factory;

/**
 * @author 하주현
 * 
 * 골드 4인 객실 구성 셋팅
 * @since 2019-05-23
 */

class FourGuestRoomGold extends GuestRoom {
  public FourGuestRoomGold() {
    name="4인 객실[3]";
    room=3;
    restRoom=2;
    kitchen=1;
    pillow=4;
    blanket=4;
    bed=2;
    rank=3;
    towel=8;
    price=25000;
  }

}
