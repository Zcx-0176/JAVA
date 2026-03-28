package Combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 组合和
 * 思路：
 * 递归
 * 主函数内不需要外部循环，如果有，那么会导致result内出现重复的元素
 * 因为递归函数内有for循环，递归的参数有index，for的i的值被赋值为index
 * 这样就可以重复选元素，并且可以接着往后选择，因为递归传递参数i了，递归到最后返回
 * 由于在for循环内递归，还要接着执行for循环，则i=i+1，这样再次传入的i就会不同
 * 递归函数首先需要判断sum是否等于target，如果相等，则加入result中，递归就可以返回，不需要接着往下执行for循环、
 * 如果不相等，证明要么sum大于target，要么sum小于target，
 * sum大于target的情况完全可以在上一级递归中判断，如果上一级递归中sum+candidates[i]>target，则直接结束掉test方法，即return回上一级递归
 * 因为sum+candidates[i]大于target了，因为数组是升序，后面一定会更大，所以就需要在递归的下面加上删除temp加入的本次元素，sum-=candidates[i]
 * 以求接下来寻找后续合适的元素
 * 如果sum+candidates[i]小于target，则把sum+=candidates[i]，并把candidates[i]加入temp中，再递归寻找即可
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        int sum = 0;
        test(candidates,0,sum,temp,target,result);
        return result;
    }
    private void test(int[] candidates,int index,int sum,List<Integer> temp,int target,List<List<Integer>> result){
        if(sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(sum + candidates[i]>target){
                return;
            }
            temp.add(candidates[i]);
            sum += candidates[i];
            test(candidates,i,sum,temp,target,result);
            sum -= candidates[i];
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] candidates = {2,3,5,6,7,8};
        int target = 8;
        System.out.println(s.combinationSum(candidates,target));
    }
}
