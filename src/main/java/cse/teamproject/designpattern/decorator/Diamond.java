package cse.teamproject.designpattern.decorator;

/**
 * @author 하주현
 * 
 * 고객의 등급(4단계)에 따라 제공되는 기본 할인률
 * @since 2019-05-15
 */

public class Diamond extends Coupon {
    
    public Diamond(){
        this.couponName="DiamondCoupon";
        this.mileage=40;
        this.discount=40;
        this.rank=4;
    }
    
}
