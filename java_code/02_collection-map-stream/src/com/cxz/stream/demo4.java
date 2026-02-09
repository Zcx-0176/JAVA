package com.cxz.stream;

public class demo4 {
    public static void main(String[] args) {

        sum(1,2,3,4,5,6,7,8,9,10);
        sum(1);
        sum();
        sum(new int[]{1,2,2});
    }
    public static void sum(int...nums){
        System.out.println(nums.length);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
