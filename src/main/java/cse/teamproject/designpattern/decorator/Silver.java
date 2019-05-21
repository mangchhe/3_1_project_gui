package cse.teamproject.designpattern.decorator;

/**
 * @author 하주현
 * 
 * 고객의 등급(2단계)에 따라 제공되는 기본 할인률
 * @since 2019-05-15
 */

public class Silver extends Coupon {
    
    public Silver(){
        this.couponName="SilverCoupon";
        this.mileage=20;
        this.discount=20;
        this.rank=2;
    }
    
}
