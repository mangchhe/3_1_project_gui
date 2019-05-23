package cse.teamproject.designpattern.factory;

/**
 * @author 하주현
 * 
 * 실버 3인 객실 구성 셋팅
 * @since 2019-05-23
 */

class ThreeGuestRoomSilver extends GuestRoom {
  public ThreeGuestRoomSilver() {
    name="3인 객실[2]";
    room=2;
    restRoom=1;
    kitchen=1;
    pillow=3;
    blanket=3;
    bed=2;
    rank=2;
    towel=6;
    price=20000;
  }

}
