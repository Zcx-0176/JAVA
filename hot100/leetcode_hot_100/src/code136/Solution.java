package code136;
/*
    只出现一次的数字
    只有一个数字出现一次
    其余数字只出现2次
    要返回出现一次的数字
    那么可以使用位运算
    累异或所有数
    可以显而易见得出，所有出现两次的数字异或后都为0了
    0与一次出现的数字异或就是一次出现的数字
 */
import java.util.*;
public class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int result = 0;
        for(int i=0;i<n;i++){
            result ^= nums[i];
        }
        return result;
    }
}
