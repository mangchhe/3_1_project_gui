package cse.teamproject.designpattern.factory;

/**
 * @author 하주현
 * 
 * 실버 5인 객실 구성 셋팅
 * @since 2019-05-23
 */

class FiveGuestRoomSilver extends GuestRoom {
  public FiveGuestRoomSilver() {
    name="5인 객실[2]";
    room=3;
    restRoom=2;
    kitchen=1;
    pillow=5;
    blanket=5;
    bed=2;
    rank=2;
    towel=10;
    price=30000;
  }

}
