package cse.teamproject.designpattern.factory;

/**
 * @author 하주현
 * 
 * 객체에 포함되어 있어야 하는 구성요소(추상클래스)
 * @since 2019-05-23
 *         2019-05-25 값 get/set 메소드 추가
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
  protected boolean[] guestRoomState = new boolean[30];
  public StringBuilder explanation = new StringBuilder();
  
  public String toString(){
      explanation.append("---------------------------------------\r\n");
      explanation.append("객실 이름 : " + name + "\r\n");
      explanation.append("객실 등급 : " + rank + "\r\n");
      explanation.append("객실 가격 : " + price + "\r\n");
      explanation.append("방 개수 : " + room + "\r\n");
      explanation.append("부엌 개수 : " + kitchen + "\r\n");
      explanation.append("화장실 개수 : " + restRoom + "\r\n");
      explanation.append("침대 개수 : " + bed + "\r\n");
      explanation.append("이불 개수 : " + blanket + "\r\n");
      explanation.append("수건 개수 : " + towel + "\r\n");
      explanation.append("베개 개수 : " + pillow + "\r\n");
      explanation.append("---------------------------------------\r\n");
      return explanation.toString();
  }
  
  public void permutePillow(int pillow){
      this.pillow += pillow;
  }
  public void permuteBlanket(int blanket){
      this.blanket += blanket;
  }
  public void permuteTowel(int towel){
      this.towel += towel;
  }
  public void permuteBed(int bed){
      this.bed += bed;
  }
  
  public int getBed(){
      return bed;
  }
  public int getBlanket(){
      return blanket;
  }
  public int getTowel(){
      return towel;
  }
  public int getPillow(){
      return pillow;
  }
  public boolean[] getState(){
      return guestRoomState;
  }
  
  public void setBed(int bed){
      this.bed=bed;
  }
  public void setBlanket(int blanket){
      this.blanket=blanket;
  }
  public void setTowel(int towel){
      this.towel=towel;
  }
  public void setPillow(int pillow){
      this.pillow=pillow;
  }
  public void setState(boolean[] guestRoomState){
      this.guestRoomState=guestRoomState;
  }
}