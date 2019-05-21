package cse.teamproject.designpattern.decorator;

/**
 * @author 하주현
 * 
 * 고객의 등급(3단계)에 따라 제공되는 기본 할인률
 * @since 2019-05-15
 */

public class Gold extends Coupon {
    
    public Gold(){
        this.couponName="GoldCoupon";
        this.mileage=30;
        this.discount=30;
        this.rank=3;
    }
    
}
