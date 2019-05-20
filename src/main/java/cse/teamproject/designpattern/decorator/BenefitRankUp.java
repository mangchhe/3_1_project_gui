package cse.teamproject.designpattern.decorator;

/**
 * @author 하주현
 * 
 * 쿠폰에 대해 추가 등급을 추가한다.
 * @since 2019-05-20
 */

public class BenefitRankUp extends CouponDecorator {
    public BenefitRankUp(Coupon coupon){
        this.coupon=coupon;
    }
    public String getCouponName(){
        return coupon.getCouponName() + " + 등급업 적용";
    }   
    public int getDiscount(){
        return coupon.getDiscount();
    }
    public int getMileage(){
        return coupon.getMileage();
    }
    public int getRank(){
        return coupon.getRank() + 1;
    }
}
