package cse.teamproject.designpattern.factory;

/**
 *
 * @author HaJuHyun
 */
public class Main {
    public static void main(String[] args){
        //GuestRoomStorage guesetRoomStorage = new GuestRoomStorage();
        GuestRoomStorage a=GuestRoomStorage.getInstance();
        GuestRoomStorage b=GuestRoomStorage.getInstance();
        
        if(a==b){
            System.out.println("같다");
        }
        else{
            System.out.println("다르다");
        }
    }
}
