package cse.teamproject.designpattern.decorator;

/**
 * @author 하주현
 * 
 * 고객의 등급(1단계)에 따라 제공되는 기본 할인률
 * @since 2019-05-15
 */

public class Bronze extends Coupon {
    
    public Bronze(){
        this.couponName="BronzeCoupon";
        this.mileage=10;
        this.discount=10;
        this.rank=1;
    }
    
}
