package Search_insertion_position;
/**
 * 使用二分查找
 * 搜索目标值
 * 当没有找到目标值时，因为如果left>right会退出循环
 * 所以没有找到target值时left大于right
 * 则left的值就是插入的位置
 * 返回left的值即可
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]==target){
                return mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,3,5,6};
        int target = 2;
        System.out.println(s.searchInsert(nums, target));
    }
}
