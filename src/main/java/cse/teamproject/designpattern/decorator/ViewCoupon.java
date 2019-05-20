package cse.teamproject.designpattern.decorator;

/**
 * @author 하주현
 * 
 * 쿠폰을 제작하는 클래스
 * @since 2019-05-20
 */

public class ViewCoupon {
    
    public static void main(String[] args){
        
        Coupon A = new Diamond();
        A.CouponState();
        
        for(int i=0;i<3;i++){
            A=new BenefitDiscount(A);
        }
        System.out.println("------------------------------------");
        A.CouponState();
    }
}
