package cse.teamproject.designpattern.factory;

/**
 * @author 하주현
 * 
 * 브론즈 4인 객실 구성 셋팅
 * @since 2019-05-23
 */

class FourGuestRoomBronze extends GuestRoom {
  public FourGuestRoomBronze() {
    name="4인 객실[1]";
    room=3;
    restRoom=2;
    kitchen=1;
    pillow=4;
    blanket=4;
    bed=2;
    rank=1;
    towel=8;
    price=25000;
  }

}
