package cse.teamproject.designpattern.factory;

/**
 * @author 하주현
 * 
 * 실버 2인 객실 구성 셋팅
 * @since 2019-05-23
 */

class TwoGuestRoomSilver extends GuestRoom {
  public TwoGuestRoomSilver() {
    name="2인 객실[2]";
    room=2;
    restRoom=1;
    kitchen=1;
    pillow=2;
    blanket=2;
    bed=1;
    rank=2;
    towel=4;
    price=15000;
  }

}
