package All_permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列
 * 思路：
 * 主要是先排序，然后循环遍历，调用递归，创建临时数组和布尔数组，添加元素到临时数组，已添加的元素的所在位置标记为true
 * 在递归函数中，先设置终止条件：递归的终止条件是temp的size等于nums的长度，即已经找到一个全排列了
 * 递归的撤销，即在permutation(nums,temp,used,result); 的下一行，在递归到最后时，无法再往下递归了，就会往下继续执行
 * 把当前的元素标识设置为 false，即撤销其标记，然后把临沭数组中的这个元素删除
 * 这个删除，其实是删除最后一个元素，因为add是顺序往后添加
 * 整体流程就是这样
 * 但是还需要去重，一是在最外层循环，确认开头元素时，重复的跳过
 * 二是在递归中，used数组为true的跳过
 * 三是在递归中，当遇到重复元素时，只有当，前一个相同元素已使用时才使用当前元素，否则跳过，确保同一层递归不选择重复元素。
 */
public class Solution {
    public List<List<Integer>> allpermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  //排序
        int n = nums.length;
        for(int i=0;i<n;i++){  //加入第一个元素，开启全排列
            if(i<n-1 && nums[i]==nums[i+1]) {  //当第一个元素与接下来的元素相同。则跳过
                continue;  //因为之前的元素开头的全排列已经完事了，这是为了去重
            }
            List<Integer> temp = new ArrayList<>();  //这是临时数组，目的是加入元素，在递归中加到n个数就证明全排列了，整体加入到result中
            temp.add(nums[i]);  //加入第一个元素
            //这个布尔数组必须在循环内创建，因为每一次加入的顺序都不同
            //若在外面创建，则进行一次全排列后，别的全排列就全是true了，没法继续
            boolean[] used = new boolean[n];  //创建布尔数组，这是为了标记已经加入temp的元素，防止重复加入
            used[i] = true;  //设置已加入的元素索引位置为 true
            permutation(nums,temp,used,result);  //调用递归函数。开始以后的元素的递归
        }
        return result;  //返回结果
    }
    //递归函数
    public void permutation(int[] nums,List<Integer> temp,boolean[] used,List<List<Integer>> result){
        if(temp.size()==nums.length){ //如果temp的大小跟nums的大小一致，说明一个全排列已经找到，加入result中
            result.add(new ArrayList<>(temp));
            return;  //返回上一级递归
        }
        for(int j=0;j<nums.length;j++){  //遍历nums数组，从头开始挨个找
            if(used[j]){  //如果used为true，则跳过，因为已经加入了
                continue;
            }
            if(j>0 && nums[j]==nums[j-1] && !used[j-1]){ //当遇到重复元素时，只有当，前一个相同元素已使用时才使用当前元素，否则跳过，确保同一层递归不选择重复元素。
                continue;
            }
            temp.add(nums[j]);  //加入元素
            used[j] = true;  //标记已加入的元素索引位置为 true
            permutation(nums,temp,used,result);  //递归
            used[j] = false;  //递归到最后，需要撤销之前的状态，为了找更多种的全排列
            temp.remove(temp.size()-1); //删除最后加入的元素
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,1,2};
        List<List<Integer>> result = s.allpermutations(nums);
        System.out.println(result);
    }
}
