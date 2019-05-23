package cse.teamproject.designpattern.factory;

/**
 * @author 하주현
 * 
 * 실버 1인 객실 구성 셋팅
 * @since 2019-05-23
 */

class OneGuestRoomSilver extends GuestRoom {
  public OneGuestRoomSilver() {
    name="1인 객실[2]";
    room=1;
    restRoom=1;
    kitchen=1;
    pillow=1;
    blanket=1;
    bed=1;
    rank=2;
    towel=2;
    price=10000;
  }

}
