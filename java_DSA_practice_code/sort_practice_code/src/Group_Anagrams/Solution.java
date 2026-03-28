package Group_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/**
 * 主要使用 HashMap哈希表来实现
 * 键值Key 为排序后的字符串，Value 为原始字符串列表
 * 遍历字符串数组，对每个字符串进行排序，并作为 key
 * 如果 hashmap 中不存在该 key，则创建一个新的 ArrayList
 * 将字符串 s 添加到对应 key 的列表中
 * 最后返回 hashmap 中所有值（分组后的字符串列表）
 **/
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hashmap = new HashMap<>();
        int n = strs.length;
        for(int i=0;i<n;i++){
            String s = strs[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(!hashmap.containsKey(key)){//如果 hashmap 中不存在该 key，创建一个新的 ArrayList
                hashmap.put(key,new ArrayList<>());
            }
            hashmap.get(key).add(s); //将字符串 s 添加到对应 key 的列表中
        }
        return new ArrayList<>(hashmap.values()); //最后返回 hashmap 中所有值（分组后的字符串列表）
    }
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        Solution solution = new Solution();
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println(result);
    }
}
