package com.fly;

/**
 * 南京地铁分段计算价格
 * @author fly
 * @date 2019/7/1
 */
public class SubwayPrice {
    /**
     * ￥(0,150],95%off
     * ￥(150,200],90%off
     * ￥(200-300],80%off
     * ￥(300,infinity),95%off
     */
    public static double price(double oriPay){
        System.out.println("原来需花费：￥"+oriPay);

        double sum = 0;
        //实际的优惠价格区间
        final int PRICE1 = 150;
        final int PRICE2 = 200;
        final int PRICE3 = 300;
        //价格区间优惠率
        final double RATE1 = 0.95;
        final double RATE2 = 0.9;
        final double RATE3 = 0.8;
        final double RATE4 = 0.95;
        //原来应支付的价格区间
        final double ORI1 = PRICE1/RATE1;                   //157
        final double ORI2 = ORI1 + (PRICE2-PRICE1)/RATE2;   //157+55=212
        final double ORI3 = ORI2 + (PRICE3-PRICE2)/RATE3;   //157+55+125=337

        if (oriPay<=0){
            System.out.println("pay must be positive");
            return -1;

        }else if (oriPay>0 && oriPay<=ORI1){
            sum = oriPay*RATE1;

        }else if (oriPay <= ORI2){
            sum = PRICE1 + (oriPay-ORI1)*RATE2;

        }else if (oriPay <= ORI3) {
            sum = PRICE2 + (oriPay-ORI2)*RATE3;

        }else{
            sum = PRICE3 + (oriPay-ORI3)*RATE4;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.printf("优惠后花费：￥%.1f",price(6*2*30));
    }
}

