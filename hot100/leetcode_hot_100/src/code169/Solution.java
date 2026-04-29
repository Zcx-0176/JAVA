package code169;
/*
    多数元素
    使用hashmap，key存储nums的数字，value存储出现次数
    然后使用
    List<Map.Entry<Integer,Integer>> list = new ArrayList<>(hashmap.entrySet());
    把键值对存储为list
    然后遍历list
    寻找最大value
    获取其key

    结果返回这个最大value的可以即可
 */

import java.util.*;
public class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!hashmap.isEmpty()){
                if(hashmap.containsKey(nums[i])){
                    int value = hashmap.get(nums[i]);
                    value++;
                    hashmap.put(nums[i],value);
                }else{
                    hashmap.put(nums[i],1);
                }
            }else{
                hashmap.put(nums[i],1);
            }
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(hashmap.entrySet());
        int maxvalue = 0;
        int maxkey = 0;
        for(Map.Entry<Integer,Integer> entery : list){
            int key = entery.getKey();
            int value = entery.getValue();
            if(value>maxvalue){
                maxvalue = value;
                maxkey = key;
            }
        }
        return maxkey;
    }
}
