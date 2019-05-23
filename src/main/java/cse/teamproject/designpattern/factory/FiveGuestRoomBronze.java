package cse.teamproject.designpattern.factory;

/**
 * @author 하주현
 * 
 * 브론즈 5인 객실 구성 셋팅
 * @since 2019-05-23
 */

public class FiveGuestRoomBronze extends GuestRoom {
  public FiveGuestRoomBronze() {
    name="5인 객실[1]";
    room=3;
    restRoom=2;
    kitchen=1;
    pillow=5;
    blanket=5;
    bed=2;
    rank=1;
    towel=10;
    price=30000;
  }

}
