package cse.teamproject.designpattern.decorator;

/**
 * @author 하주현
 * 
 * 쿠폰에 대해 마일리지 보너스를 추가한다.
 * @since 2019-05-20
 */
public class BenefitPoint extends CouponDecorator {
    public BenefitPoint(Coupon coupon){
        this.coupon=coupon;
    }
    public String getCouponName(){
        return coupon.getCouponName() + " + 보너스 포인트 적용";
    }    
    public int getDiscount(){
        return coupon.getDiscount();
    }
    public int getMileage(){
        return coupon.getMileage() + 10;
    }
    public int getRank(){
        return coupon.getRank();
    }
}
