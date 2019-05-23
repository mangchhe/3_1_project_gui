package cse.teamproject.designpattern.factory;

/**
 * @author 하주현
 * 
 * 골드 1인 객실 구성 셋팅
 * @since 2019-05-23
 */

class OneGuestRoomGold extends GuestRoom {
  public OneGuestRoomGold() {
    name="1인 객실[3]";
    room=1;
    restRoom=1;
    kitchen=1;
    pillow=1;
    blanket=1;
    bed=1;
    rank=3;
    towel=2;
    price=10000;
  }

}
