package cse.teamproject.designpattern.factory;

/**
 * @author 하주현
 * 
 * 객체에 포함되어 있어야 하는 구성요소(추상클래스)
 * @since 2019-05-23
 */

public abstract class GuestRoom {
  protected String name;
  protected int room;
  protected int restRoom;
  protected int kitchen;
  protected int pillow;
  protected int blanket;
  protected int towel;
  protected int rank;
  protected int price;
  protected int bed;
  protected StringBuilder explanation = new StringBuilder();
  
  public String toString(){
      explanation.append("---------------------------------------\n");
      explanation.append("객실 이름 : " + name + "\n");
      explanation.append("객실 등급 : " + rank + "\n");
      explanation.append("객실 가격 : " + price + "\n");
      explanation.append("방 개수 : " + room + "\n");
      explanation.append("부엌 개수 : " + kitchen + "\n");
      explanation.append("화장실 개수 : " + restRoom + "\n");
      explanation.append("침대 개수 : " + bed + "\n");
      explanation.append("이불 개수 : " + blanket + "\n");
      explanation.append("수건 개수 : " + towel + "\n");
      explanation.append("베개 개수 : " + pillow + "\n");
      explanation.append("---------------------------------------\n");
      return explanation.toString();
  }
  
  public void permutePillow(){}
  public void permuteBlanket(){}
  public void permuteTowel(){}
}