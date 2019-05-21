package cse.teamproject.designpattern.decorator;

/**
 * @author 하주현
 * 
 * 쿠폰에 대해 기본값 설정
 * @since 2019-05-15
 */

public abstract class Coupon {
    
    protected String couponName;
    protected int mileage;
    protected int discount;
    protected int rank;
    
    public Coupon(){
        couponName="fault";
        mileage=0;
        discount=0;
        rank=0;
    }
    
    public String getCouponName(){
        return this.couponName;
    }
    public int getMileage(){
        return this.mileage;
    }
    public int getDiscount(){
        return this.discount;
    } 
    public int getRank(){
        return this.rank;
    }
    
    public void CouponState(){
        System.out.println("쿠폰 이름 : " + this.getCouponName());
        System.out.println("추가 마일리지 : " + this.getMileage() + "%");
        System.out.println("할인율 : " + this.getDiscount() + "%");
        System.out.println("등급 레벨 : " + this.getRank() + "단계");
    }
    
}
