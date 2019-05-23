package cse.teamproject.designpattern.factory;

/**
 * @author 하주현
 * 
 * 실버 4인 객실 구성 셋팅
 * @since 2019-05-23
 */

class FourGuestRoomSilver extends GuestRoom {
  public FourGuestRoomSilver() {
    name="4인 객실[2]";
    room=3;
    restRoom=2;
    kitchen=1;
    pillow=4;
    blanket=4;
    bed=2;
    rank=2;
    towel=8;
    price=25000;
  }

}
