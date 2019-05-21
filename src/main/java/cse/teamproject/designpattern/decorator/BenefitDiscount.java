package cse.teamproject.designpattern.decorator;

/**
 * @author 하주현
 * 
 * 쿠폰에 대해 할인율을 추가시킨다.
 * @since 2019-05-15
 */

public class BenefitDiscount extends CouponDecorator {
    public BenefitDiscount(Coupon coupon){
        this.coupon=coupon;
    }
    public String getCouponName(){
        return coupon.getCouponName() + " + 할인율 적용";
    }
    public int getDiscount(){
        return coupon.getDiscount() + 10;
    }
    public int getMileage(){
        return coupon.getMileage();
    }
    public int getRank(){
        return coupon.getRank();
    }
}
