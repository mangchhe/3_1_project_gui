package cse.teamproject.designpattern.singleton;

import cse.teamproject.designpattern.factory.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 하주현
 * 
 * 각 객실의 정보를 가지고 있는 객체들의 저장소를 같은 메모리 공간에 활용할 수 있도록 싱글톤 패턴 이용
 * @since 2019-05-25
 *         2019-05-25 (파일 입출력 : 객실을 생성할 때 파일 DB에 저장된 내용을 불러온다.)
 */

public class GuestRoomStorage {
    
    private static GuestRoomStorage guestRoomStorage;
    
    public static GuestRoomBuild oneRoom = new OneGuestRoomBuild();
    public static GuestRoomBuild twoRoom = new TwoGuestRoomBuild();
    public static GuestRoomBuild threeRoom = new ThreeGuestRoomBuild();
    public static GuestRoomBuild fourRoom = new FourGuestRoomBuild();
    public static GuestRoomBuild fiveRoom = new FiveGuestRoomBuild();
    public static GuestRoom[] guestRoom = new GuestRoom[20];
    
    private BufferedReader br=null;
    
    private GuestRoomStorage(){
        guestRoom[0]=oneRoom.selectGuestRoom("Bronze");
        guestRoom[1]=oneRoom.selectGuestRoom("Silver");
        guestRoom[2]=oneRoom.selectGuestRoom("Gold");
        guestRoom[3]=oneRoom.selectGuestRoom("Diamond");
        
        guestRoom[4]=twoRoom.selectGuestRoom("Bronze");
        guestRoom[5]=twoRoom.selectGuestRoom("Silver");
        guestRoom[6]=twoRoom.selectGuestRoom("Gold");
        guestRoom[7]=twoRoom.selectGuestRoom("Diamond");
        
        guestRoom[8]=threeRoom.selectGuestRoom("Bronze");
        guestRoom[9]=threeRoom.selectGuestRoom("Silver");
        guestRoom[10]=threeRoom.selectGuestRoom("Gold");
        guestRoom[11]=threeRoom.selectGuestRoom("Diamond");
        
        guestRoom[12]=fourRoom.selectGuestRoom("Bronze");
        guestRoom[13]=fourRoom.selectGuestRoom("Silver");
        guestRoom[14]=fourRoom.selectGuestRoom("Gold");
        guestRoom[15]=fourRoom.selectGuestRoom("Diamond");
        
        guestRoom[16]=fiveRoom.selectGuestRoom("Bronze");
        guestRoom[17]=fiveRoom.selectGuestRoom("Silver");
        guestRoom[18]=fiveRoom.selectGuestRoom("Gold");
        guestRoom[19]=fiveRoom.selectGuestRoom("Diamond");
        
        for(int i=0;i<20;i++){
            int count=0;
            try{
                br = new BufferedReader(new FileReader("guestroomdb/"+i+".txt"));
            while(true){
                String line = br.readLine();
                if(line == null){
                    br.close();
                    break;
                }
                if(count == 0){
                    guestRoom[i].setBed(Integer.parseInt(line));
                }
                else if(count == 1){
                    guestRoom[i].setBlanket(Integer.parseInt(line));
                }
                else if (count == 2){
                    guestRoom[i].setTowel(Integer.parseInt(line));
                }
                else if (count == 3){
                    guestRoom[i].setPillow(Integer.parseInt(line));
                }
                else{
                    System.out.println("좌석 현황 넣을 예정");
                }
                count++;
            }
            }catch(IOException e){
                System.out.println("파일을 열지 못했습니다.");
            }
        }
        for(int i=0;i<20;i++){
            boolean[] temp = new boolean[30];
            int count=0;
            try{
                br = new BufferedReader(new FileReader("reservationState/"+i+".txt"));
                while(true){
                    String line = br.readLine();
                    if(line == null){
                        br.close();
                        break;
                    }
                    temp[count]=Boolean.parseBoolean(line);
                    count++;
                }
                guestRoom[i].setState(temp);
            }catch(IOException ex){
                System.out.println("파일을 열지 못했습니다.");
            }
        }
    }
    public static GuestRoomStorage getInstance(){
        if(guestRoomStorage==null){
            guestRoomStorage = new GuestRoomStorage();
        }
        return guestRoomStorage;
    }
    
    public GuestRoom[] getStorage(){
        return guestRoom;
    }
}