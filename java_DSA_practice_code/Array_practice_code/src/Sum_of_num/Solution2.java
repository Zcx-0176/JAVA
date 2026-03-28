package Sum_of_num;

import java.util.HashMap;
/**
 * 思路：
 * 创建一个HashMap，将数组的元素作为key，索引作为value
 * 因为由于HashMap只能根据Key找value，而不能反过来
 * 所以为了获取目标值的索引，必须把索引放在Key中
 * 遍历数组，判断target-nums[i]是否存在于map中
 * 如果存在，则返回当前索引i和map.get(target-nums[i])
 * 并且根据题目要求，重复索引的元素不可重复使用
 * 故需要加一个判断，如果当前元素索引与目标索引不一致的时候才返回
 */
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<n;i++){
            if(map.containsKey(target-nums[i])){
                int j = map.get(target-nums[i]);
                if(i!=j) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
