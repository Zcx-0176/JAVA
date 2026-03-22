package Container_with_most_water;
/**
 * 这实际上是双指针
 * 双指针的移动判断很简单，不需要那么多比较
 * 因为盛水最多就需要短板长一点，才有可能盛更多的水
 * 所以只要每次看当前的左右指针的高度大小
 * 高度小的，证明需要移动，高度大的暂时不需要移动
 * 故
 * if(height[left]<height[right]){
 *      left++;
 *     }else{
 *       right--;
 *     }
 */
public class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int sum = 0;
        while(left<right){
            int temp = (right-left)*(Math.min(height[left],height[right]));
            sum = Math.max(sum,temp);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        Solution s = new Solution();
        System.out.println(s.maxArea(height));
    }
}
